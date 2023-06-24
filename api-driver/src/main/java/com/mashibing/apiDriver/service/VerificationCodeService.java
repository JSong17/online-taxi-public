package com.mashibing.apiDriver.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import org.springframework.stereotype.Service;

/*
 *@author js
 *@version 1.0
 */
@Service
public class VerificationCodeService {

    public ResponseResult checkAndsendVerificationCode(String driverPhone){
        //查询service-driver-user，该手机号的司机是否存在

        //获取验证码

        //调用第三方发生的验证码

        //存入redis

        return ResponseResult.success("");
    }

}
