package com.mashibing.apipassenger.service;

import com.mashibing.internalcommon.dto.PassengerUser;
import com.mashibing.internalcommon.dto.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
 *@author js
 *@version 1.0
 */
@Service
@Slf4j
public class UserService {

    public ResponseResult getUserByAccessToken(String accessToken){
        log.info("accessToken: " + accessToken);

        //解析accessToken，拿到手机号

        //根据手机号查询用户信息

        PassengerUser passengerUser = new PassengerUser();
        passengerUser.setPassengerName("张三");
        passengerUser.setProfilePhoto("头像");


        return ResponseResult.success(passengerUser);





    }
}