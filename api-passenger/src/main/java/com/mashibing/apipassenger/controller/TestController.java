package com.mashibing.apipassenger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@author js
 *@version 1.0
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){

        return "test api passenger";
    }

}
