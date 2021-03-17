package com.igeekhome.util;


import java.math.BigInteger;
import java.security.MessageDigest;

public class Test {
    public static void main(String[] args) throws Exception{

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update("abc".getBytes());

        String str=new BigInteger(1,md5.digest()).toString();
        System.out.println(str);

        MessageDigest md6 = MessageDigest.getInstance("MD5");
        md6.update("abc".getBytes());

        String str6=new BigInteger(1,md6.digest()).toString();
        System.out.println(str6);

    }
}
