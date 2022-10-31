package com.actmos.sdk.station.common;

import com.actmos.sdk.station.dto.user.LoginSecretDataDTO;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

/**
 * AES加解密工具类
 *
 * @Date 2020/12/5-14:11
 */
public class EncryptAndDecryptUtil {
    /**
     * 密钥算法 AES
     */
    private static final String KEY_ALGORITHM = "AES";

    /**
     * 加解密算法/工作模式/填充方式
     * java支持PKCS5Padding、不支持PKCS7Padding
     * Bouncy Castle支持PKCS7Padding填充方式
     */
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";

    /**
     * 偏移量，CBC模式需要
     * 与其他语言平台使用的需一致才能通用加解密
     */
    private static final String IV = "0000000000000000";

    public static final String ENCODING = "UTF-8";

    static {
        // 是PKCS7Padding填充方式，则需要添加Bouncy Castle支持
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * AES加密方法
     *
     * @param source 原文
     * @param password 加密密钥 (长度要求16/24/32)
     * @return 密文
     */
    public static String encrypt(String source, String password) throws Exception {
        byte[] sourceBytes = source.getBytes(ENCODING);
        byte[] passwordBytes = password.getBytes(ENCODING);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
        IvParameterSpec iv = new IvParameterSpec(IV.getBytes(ENCODING));
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(passwordBytes, KEY_ALGORITHM), iv);
        byte[] encryptBytes = cipher.doFinal(sourceBytes);
        String encryptText = Base64.encodeBase64String(encryptBytes);
        return encryptText;
    }

    /**
     * AES解密方法
     *
     * @param encryptText 密文
     * @param password 密码
     * @return 原文
     */
    public static String decrypt(String encryptText, String password) throws Exception {
        byte[] sourceBytes = Base64.decodeBase64(encryptText);
        byte[] passwordBytes = password.getBytes(ENCODING);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
        IvParameterSpec iv = new IvParameterSpec(IV.getBytes(ENCODING));
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(passwordBytes, KEY_ALGORITHM), iv);
        byte[] decryptBytes = cipher.doFinal(sourceBytes);
        return new String(decryptBytes, ENCODING);
    }

    /**
     * AES密码长度只能为16/24/32个字符长度
     * @param pwd
     * @return
     */
    public static String checkPassword(String pwd) throws Exception {
        while (pwd == null || "".equals(pwd) || pwd.length() < 16) {
            throw new Exception("密码长度需为16个或以上长度的字符");
        }
        if (pwd.length() < 32) {
            int lessNum = 32 - pwd.length();
            StringBuilder builder = new StringBuilder(32);
            builder.append(pwd);
            for (int i = 0; i < lessNum; i++) {
                builder.append("a");
            }
            pwd = builder.toString();
        }
        if (pwd.length() > 32) {
            pwd = pwd.substring(0, 32);
        }
        return pwd;
    }

    public static void main(String[] args) throws Exception {
        LoginSecretDataDTO loginSecretDataDTO = new LoginSecretDataDTO();
        loginSecretDataDTO.setOpenId("asjaslkdfjaslkdfjas");
        // key长度要求16/24/32
        String secretData = encrypt(JSONObject.toJSONString(loginSecretDataDTO), "91754573fe83df46");
        System.out.println(secretData);

        String data = decrypt(secretData, "91754573fe83df46");
        System.out.println(data);
    }
}
