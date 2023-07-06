package com.mashibing.apiDriver.service;

import com.mashibing.apiDriver.remote.ServiceSsePushClient;
import com.mashibing.internalcommon.constant.IdentityConstants;
import com.mashibing.internalcommon.dto.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@author js
 *@version 1.0
 */
@Service
public class PayService {

    @Autowired
    ServiceSsePushClient serviceSsePushClient;

    public ResponseResult pushPayInfo(String orderId,String price,Long passengerId){
        //封装信息
        JSONObject message = new JSONObject();
        message.put("price",price);
        //推送信息
        serviceSsePushClient.push(passengerId, IdentityConstants.PASSENGER_IDENTITY, message.toString());
        return ResponseResult.success();
    }
}
