package com.mashibing.servicemap.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.DirectionResponse;
import com.mashibing.servicemap.remote.MapDirectionClient;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.pattern.PathPattern;

/*
 *@author js
 *@version 1.0
 */
@Service
@Slf4j
public class DirectionService {
    @Autowired
    private MapDirectionClient mapDirectionClient;

    /*
    * 根据起点经纬度和终点经纬度获取距离(米)和时长(分钟)
    * */
    public ResponseResult driving(String depLongitude, String depLatitude, String destLongitude, String destLatitude){

        //调用第三方地图接口
        DirectionResponse direction = mapDirectionClient.direction(depLongitude, depLatitude, destLongitude, destLatitude);


        return ResponseResult.success(direction);
    }
}
