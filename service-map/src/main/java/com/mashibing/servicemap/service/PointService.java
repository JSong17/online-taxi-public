package com.mashibing.servicemap.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.request.PointRequest;
import com.mashibing.servicemap.remote.PointClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@author js
 *@version 1.0
 */
@Service
public class PointService {

    @Autowired
    PointClient pointClient;

    public ResponseResult upload(PointRequest pointRequest){
        return pointClient.upload(pointRequest);
    }
}
