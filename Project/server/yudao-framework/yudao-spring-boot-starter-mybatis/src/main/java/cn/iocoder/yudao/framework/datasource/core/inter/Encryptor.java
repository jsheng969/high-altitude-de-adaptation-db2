package cn.iocoder.yudao.framework.datasource.core.inter;

public interface Encryptor {
    String encrypt(String rawValue);
    String decrypt(String cipherValue);
}
