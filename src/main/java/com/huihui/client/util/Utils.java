package com.huihui.client.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class Utils {

    public static final int RETURN_CODE = -1;

    public static int toInteger(String inte) {
        int a = RETURN_CODE;
        if (StringUtils.isNotEmpty(inte)) {
            try {
                a = Integer.valueOf(inte);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return a;
    }

    public static boolean isInteger(String inte) {
        if (StringUtils.isNotEmpty(inte)) {
            try {
                Integer.valueOf(inte);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static int fromGetUserId(String from) {
        int userId = RETURN_CODE;
        if (StringUtils.isNotEmpty(from)) {
            String[] split = from.split("_");
            if (split != null && split.length == 2) {
                try {
                    userId = Integer.valueOf(split[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return userId;
    }

    public static String fromGetTag(String from){
        String tag = "";
        if(StringUtils.isNotEmpty(from)){
            String[] s = from.split("_");
            if(s != null && s.length == 2){
                tag = s[0];
            }
        }
        return tag;
    }

    /**
     * 随机数
     * @return
     */
    public static String randomNumber(){
        return String.valueOf(Math.random()).substring(2, 8) + new Date().getTime();
    }
}
