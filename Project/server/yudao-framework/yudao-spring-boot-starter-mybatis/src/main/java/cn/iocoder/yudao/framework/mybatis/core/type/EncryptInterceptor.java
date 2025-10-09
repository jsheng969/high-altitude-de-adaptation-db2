package cn.iocoder.yudao.framework.mybatis.core.type;

import cn.iocoder.yudao.framework.datasource.core.inter.EncryptField;
import cn.iocoder.yudao.framework.datasource.core.inter.Encryptor;
import cn.iocoder.yudao.framework.mybatis.core.factory.EncryptorFactory;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Collection;
import java.util.Objects;
import java.util.Properties;

@Intercepts({
        @Signature(type = ParameterHandler.class, method = "setParameters", args = {PreparedStatement.class}),
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})
public class EncryptInterceptor implements Interceptor {

    private final Encryptor encryptor = EncryptorFactory.getEncryptor();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof ParameterHandler) {
            handleEncrypt((ParameterHandler) invocation.getTarget());
        } else if (invocation.getTarget() instanceof ResultSetHandler) {
            // 查询结果时解密
            Object result = invocation.proceed();
            if (result instanceof Collection) {
                for (Object obj : (Collection<?>) result) {
                    handleDecrypt(obj);
                }
            } else {
                handleDecrypt(result);
            }
            return result;
        }
        return invocation.proceed();
    }

    private void handleEncrypt(ParameterHandler parameterHandler) {
        try {
            BoundSql boundSql = (BoundSql) getField(parameterHandler, "boundSql");
            Object paramObj = boundSql.getParameterObject();
            if (paramObj == null) return;

            if (paramObj instanceof java.util.Map) {
                for (Object val : ((java.util.Map<?, ?>) paramObj).values()) {
                    processEncrypt(val);
                }
            } else {
                processEncrypt(paramObj);
            }
        } catch (Exception e) {
            throw new RuntimeException("加密参数时出错", e);
        }
    }

    private void handleDecrypt(Object result) {
        if (result == null) return;
        for (Field field : result.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(EncryptField.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(result);
                    if (value instanceof String && Objects.nonNull(value)) {
                        field.set(result, encryptor.decrypt((String) value));
                    }
                } catch (Exception ignored) {
                }
            }
        }
    }

    private boolean isEncrypted(String val) {
        try {
            String decrypt = encryptor.decrypt(val);
            if (Objects.equals(val, decrypt)) {
                return false; // 解密前后相同 → 明文
            }
            return true; // 能解密 → 已经加密
        } catch (Exception e) {
            return false; // 解密失败 → 明文
        }
    }


    private void processEncrypt(Object obj) {
        if (obj == null) return;
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(EncryptField.class)) {
                field.setAccessible(true);
                try {
                    Object val = field.get(obj);
                    if (val != null && val instanceof String && !isEncrypted((String) val)) {
                        field.set(obj, encryptor.encrypt(val.toString()));
                    }
                } catch (Exception e) {
                    throw new RuntimeException("字段加密失败: " + field.getName(), e);
                }
            }
        }
    }

    private void processDecrypt(Object obj) {
        if (obj == null) return;
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(EncryptField.class)) {
                field.setAccessible(true);
                try {
                    Object val = field.get(obj);
                    if (val != null) {
                        field.set(obj, encryptor.decrypt(val.toString()));
                    }
                } catch (Exception e) {
                    // 解密失败时返回原值（兼容老数据）
                }
            }
        }
    }

    private Object getField(Object target, String fieldName) throws Exception {
        MetaObject metaObject = SystemMetaObject.forObject(target);
        return metaObject.getValue(fieldName);
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        // 可配置参数留空
    }
}
