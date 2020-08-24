package com.example.SecurityStudy;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class S_Base64 {

    public static void main(String[] args) throws Exception {

        String str="hello world";
        byte[] ba=str.getBytes();

        //加密
        String encryptStr=encryptBASE64(ba);
        System.out.println(encryptStr);

        //解密
        String decryptStr=new String(decryptBASE64(encryptStr));
        System.out.println(decryptStr);
    }

    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }
}
