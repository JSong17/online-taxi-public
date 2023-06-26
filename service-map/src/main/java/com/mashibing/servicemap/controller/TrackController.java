package com.mashibing.servicemap.controller;

/*
 *@author js
 *@version 1.0
 */

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.TrackResponse;
import com.mashibing.servicemap.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    TrackService trackService;

    @PostMapping("/add")
    public ResponseResult<TrackResponse> add(String tid){
        return trackService.add(tid);
    }


}
