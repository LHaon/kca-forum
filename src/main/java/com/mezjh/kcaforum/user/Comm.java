package com.mezjh.kcaforum.user;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zjh
 * @date 2020/4/22
 */
public class Comm {
    /**
     * 判读是否是手机号正则表达式
     */
    public static final String PHONE_REG = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
    /**
     * 默认头像地址
     */
    public static final String HEAD_PHOTO_URL = "http://image-mezjh.test.upcdn.net/kca/15181091307/photo.jpeg";
    /**
     * 生成随机昵称
     * @param phone
     * @return
     */
    public static String getBaseNickname(String phone) {
        StringBuffer sb = new StringBuffer("@kca_");
        for (int i = 0; i < phone.length();i++) {
            sb.append((char)('a' + Integer.parseInt(String.valueOf(phone.charAt(i)))));
        }
        return sb.toString();
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getNowTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(getBaseNickname("15181091307"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(new Date()));
    }
}
