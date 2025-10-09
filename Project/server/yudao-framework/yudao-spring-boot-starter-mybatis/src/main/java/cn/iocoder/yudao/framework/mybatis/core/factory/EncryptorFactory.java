package cn.iocoder.yudao.framework.mybatis.core.factory;

import cn.hutool.core.lang.Assert;
import cn.hutool.extra.spring.SpringUtil;
import cn.iocoder.yudao.framework.datasource.core.inter.Encryptor;
import cn.iocoder.yudao.framework.mybatis.core.util.AesEncryptor;
import cn.iocoder.yudao.framework.mybatis.core.util.Sm4Encryptor;

public class EncryptorFactory {
    private static Encryptor encryptor;

    public static Encryptor getEncryptor() {
        if (encryptor != null) {
            return encryptor;
        }

        String algorithm = SpringUtil.getProperty("mybatis-plus.encryptor.algorithm", "aes");
        String password = SpringUtil.getProperty("mybatis-plus.encryptor.password");
        Assert.notEmpty(password, "配置项 mybatis-plus.encryptor.password 不能为空");

        switch (algorithm.toLowerCase()) {
            case "aes":
                encryptor = new AesEncryptor(password);
                break;
            case "sm4":
                encryptor = new Sm4Encryptor(password);
                break;
            // TODO: 如果以后要扩展 SM4、RSA，可以在这里加 case
            default:
                throw new IllegalArgumentException("不支持的加密算法: " + algorithm);
        }
        return encryptor;
    }
}
