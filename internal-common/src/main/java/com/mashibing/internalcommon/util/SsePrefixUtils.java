package com.mashibing.internalcommon.util;

/*
 *@author js
 *@version 1.0
 */
public class SsePrefixUtils {
    public static final String sperator = "$";

    public static String generatorSseKey(Long userId, String identity){
        return userId+sperator+identity;
    }
}
