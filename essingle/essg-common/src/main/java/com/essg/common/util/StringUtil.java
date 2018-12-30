package com.essg.common.util;

public class StringUtil {

    public static boolean isNull(String value){
        return value == null;
    }

    public static boolean isEmpty(String value){
        return value == null || value == "" || value.length() == 0;
    }

    public static boolean isNullOrEmpty(String value){
        return isNull(value) || isEmpty(value);
    }

//    public static boolean is(String value){
//
//    }
}
