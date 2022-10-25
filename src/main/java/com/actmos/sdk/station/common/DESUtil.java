package com.actmos.sdk.station.common;



import com.actmos.sdk.station.config.Constants;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * DES算法实现
 *
 * @author zhiguang@crossevery.com
 * @date 2018/5/8 17:35
 */
public class DESUtil {

    /**
     * 生成密钥
     *
     * @throws Exception
     */
    public static byte[] initKey() throws Exception {
        //密钥生成器
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        //初始化密钥生成器
        keyGen.init(56);
        //生成密钥
        SecretKey secretKey = keyGen.generateKey();
        return secretKey.getEncoded();
    }

    /**
     * 加密
     *
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        //获得密钥
        SecretKey secretKey = new SecretKeySpec(key, "DES");
        //Cipher完成加密
        Cipher cipher = Cipher.getInstance("DES");
        //初始化cipher
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        //加密
        byte[] encrypt = cipher.doFinal(data);

        return encrypt;
    }

    /**
     * 解密
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        //恢复密钥
        SecretKey secretKey = new SecretKeySpec(key, "DES");
        //Cipher完成解密
        Cipher cipher = Cipher.getInstance("DES");
        //初始化cipher
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        //解密
        byte[] plain = cipher.doFinal(data);

        return plain;
    }

    /**
     * 字节码转化十六进制
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (Integer.toHexString(0xFF & bytes[i]).length() == 1) {
                builder.append("0").append(Integer.toHexString(0xFF & bytes[i]));
            } else {
                builder.append(Integer.toHexString(0xFF & bytes[i]));
            }
        }
        return builder.toString();
    }

    /**
     * 将表示16进制值的字符串转换为byte数组
     *
     * @param hexStr
     * @return
     */
    public static byte[] hexToBytes(String hexStr) {
        byte[] hexBytes = hexStr.getBytes();
        int iLen = hexBytes.length;

        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] result = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(hexBytes, i, 2);
            result[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        String data = "05772da32dce43e3a8a76917b880307e";
		byte[] desKey = DESUtil.hexToBytes(Constants.DES_KEY);
		byte[] desResult = DESUtil.encrypt(data.getBytes(), desKey);
		byte[] plain = DESUtil.decrypt(desResult, desKey);
		System.out.println("加密前：" + data);
		System.out.println("加密后：" + DESUtil.bytesToHex(desResult));
		System.out.println("解密后：" + new String(plain));
    }

}