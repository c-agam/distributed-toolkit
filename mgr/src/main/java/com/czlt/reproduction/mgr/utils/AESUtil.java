package com.czlt.reproduction.mgr.utils;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class AESUtil {

    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";


    private static Key toKey(String key) throws Exception {
        return new SecretKeySpec(key.getBytes(ApiConstants.DEFAULT_CHARSET_NAME), KEY_ALGORITHM);
    }

    public static byte[] encrypt(byte[] data, String key) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, toKey(key));
            return BASE64.encode(cipher.doFinal(data)).getBytes(ApiConstants.DEFAULT_CHARSET_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public static byte[] decrypt(byte[] data, String key) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, toKey(key));
            return cipher.doFinal(BASE64.decode(new String(data,ApiConstants.DEFAULT_CHARSET_NAME)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public static void main(String[] args) throws  Exception{
        String params = new String(AESUtil.encrypt("afeagweerga#$%342q14#%$#@$&dbaf".getBytes(), "123456789%^%$#zR"),
                ApiConstants.DEFAULT_CHARSET_NAME);
        System.out.println("------------" + params);
        byte[] destr =  AESUtil.decrypt("9gGDO1qDwzqJmuTlumVcd2ZgyqsEYZ9kx799NJN0T1c=".getBytes(), "123456789%^%$#zR");
        System.out.println("------------" +  new String(destr, ApiConstants.DEFAULT_CHARSET_NAME));
    }
}
