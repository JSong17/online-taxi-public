package com.mashibing.apiDriver.controller;

import com.mashibing.apiDriver.service.PointService;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.request.ApiDriverPointRequest;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 *@author js
 *@version 1.0
 */
@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    PointService pointService;

    @PostMapping("/upload")
    public ResponseResult upload(@RequestBody ApiDriverPointRequest apiDriverPointRequest){
        return pointService.upload(apiDriverPointRequest);
    }
}
