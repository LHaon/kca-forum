package com.mezjh.kcaforum.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zjh
 * @date 2020/4/21
 */
public class MdFive {
    /**
     * 对字符串进行Md5加密
     *
     * @param input 原文
     * @return md5后的密文
     */
    public static String md5(String input) {
        byte[] code = null;
        try {
            code = MessageDigest.getInstance("md5").digest(input.getBytes());
        } catch (NoSuchAlgorithmException e) {
            code = input.getBytes();
        }
        BigInteger bi = new BigInteger(code);
        return bi.abs().toString(32).toUpperCase();
    }

    /**
     * 对字符串进行Md5加密
     *
     * @param input 原文
     * @param salt 随机数
     * @return string
     */
    public static String md5(String input, String salt) {
        if(StringUtils.isEmpty(salt)) {
            salt = "";
        }
        return md5(salt + md5(input));
    }
}
