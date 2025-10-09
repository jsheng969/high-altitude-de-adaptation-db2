package cn.iocoder.yudao.framework.mybatis.core.util;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;
import cn.iocoder.yudao.framework.datasource.core.inter.Encryptor;

public class Sm4Encryptor implements Encryptor {
    private final SM4 sm4;

    public Sm4Encryptor(String password) {
        if (password == null || password.length() != 16) {
            throw new IllegalArgumentException("SM4 密钥长度必须为16位");
        }
        this.sm4 = SmUtil.sm4(password.getBytes());
    }

    @Override
    public String encrypt(String rawValue) {
        if (rawValue == null) return null;
        return sm4.encryptBase64(rawValue);
    }

    @Override
    public String decrypt(String cipherValue) {
        if (cipherValue == null) return null;
        try {
            return sm4.decryptStr(cipherValue);
        } catch (Exception e) {
            // 兼容老数据（明文）
            return cipherValue;
        }
    }
}
