package com.mashibing.internalcommon.util;

/*
 *@author js
 *@version 1.0
 */
public class RedisPrefixUtils {

    //乘客验证码的前缀
    public static String verificationCodePrefix = "passenger-verification-code-";

    //token存储的前缀
    public static String tokenPrefix = "token-";


    /*
     * 根据手机号，生成key
     * */
    public static String generatorKeyByPhone(String passengerPhone){
        return verificationCodePrefix + passengerPhone;
    }


    /*
     * 根据手机号何身份标识，生成token
     * */
    public static String generatorTokenKey(String phone,String identity,String tokenType){
        return  tokenPrefix + phone + "-" + identity +"-" + tokenType;
    }

}
