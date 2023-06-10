package com.mashibing.servicepassengeruser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@author js
 *@version 1.0
 */
@RestController
public class TestController {

    @GetMapping
    public  String test(){
        return  "service-passenger-user";
    }
}
