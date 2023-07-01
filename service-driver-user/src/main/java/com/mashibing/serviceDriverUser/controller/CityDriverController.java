package com.mashibing.serviceDriverUser.controller;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.serviceDriverUser.service.CityDriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

/*
 *@author js
 *@version 1.0
 */
@RestController
@RequestMapping("/city-driver")
public class CityDriverController {

    @Autowired
    CityDriverUserService cityDriverUserService;

    @GetMapping("/is-alailable-driver")
    public ResponseResult isAvailableDriver(String cityCode){
        return cityDriverUserService.isAvailableDriver(cityCode);
    }
}
