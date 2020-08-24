package com.example.SecurityStudy;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class S_SHA {

    public static void main(String[] args) throws Exception {
        String str="hello world";
        byte[] ba=str.getBytes();

        String shaStr = getSHAStr(str);
        System.out.println(shaStr);
    }

    public static String getSHAStr(String str) {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("SHA");
            digest  = md5.digest(str.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        return md5Str;
    }
}
