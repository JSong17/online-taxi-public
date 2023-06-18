package com.mashibing.servicemap.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.DirectionResponse;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
 *@author js
 *@version 1.0
 */
@Service
@Slf4j
public class DirectionService {

    /*
    * 根据起点经纬度和终点经纬度获取距离(米)和时长(分钟)
    * */
    public ResponseResult driving(String depLongitude, String depLatitude, String destLongitude, String destLatitude){
        DirectionResponse directionResponse = new DirectionResponse();
        directionResponse.setDistance(123);
        directionResponse.setDuration(11);
        return ResponseResult.success(directionResponse);
    }
}
