package com.mashibing.apiDriver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@author js
 *@version 1.0
 */
@RestController
public class TestController {

    /*
    * 需要授权的接口
    * */
    @GetMapping("/auth")
    public String testAuth(){
        return "auth";
    }

    /*
     * 不需要授权的接口
     * */
    @GetMapping("/noauth")
    public String testNoAuth(){
        return "no auth";
    }



}
