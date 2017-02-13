package org.smart4j.framework.util;

/**
 * Created by 35429 on 2016/12/8.
 * 字符串工具类
 */
public final class StringUtil {
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if(str != null)
            str = str.trim();
        return StringUtil.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String[] spiltString(String string, String spilt) {
        String[] strings = string.split(spilt);
        return strings;
    }
}
