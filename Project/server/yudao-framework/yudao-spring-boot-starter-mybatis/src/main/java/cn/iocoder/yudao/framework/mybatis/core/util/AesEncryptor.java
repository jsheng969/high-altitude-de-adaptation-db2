package cn.iocoder.yudao.framework.mybatis.core.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.iocoder.yudao.framework.datasource.core.inter.Encryptor;

public class AesEncryptor implements Encryptor {

    private final AES aes;

    public AesEncryptor(String password) {
        this.aes = SecureUtil.aes(password.getBytes());
    }

    @Override
    public String encrypt(String rawValue) {
        if (rawValue == null) return null;
        return aes.encryptBase64(rawValue);
    }

    @Override
    public String decrypt(String cipherValue) {
        if (cipherValue == null) return null;
        try {
            return aes.decryptStr(cipherValue);
        } catch (Exception e) {
            // 兼容老数据（明文）
            return cipherValue;
        }
    }

    public static void main(String[] args) {
        AES aes = SecureUtil.aes("XDV71a+xqStEA3WH".getBytes());
        String s = aes.decryptStr("loNAYZ1UeuQjJYEJB6sHcri1boCU2ggqgfPc1Pjahho=");
        System.out.println(s);
    }
}
