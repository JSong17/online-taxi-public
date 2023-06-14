package com.mashibing.apipassenger.controller;

import com.mashibing.internalcommon.dto.ResponseResult;
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

    /*
    * 需要有token
    *
    * */
    @GetMapping("/authTest")
    public ResponseResult authTest(){
        return  ResponseResult.success("auth test");
    }


    /*
    * 没有token也能正常返回
    * */
    @GetMapping("/noauthTest")
    public ResponseResult noauthTest(){
        return  ResponseResult.success("noauth test");
    }






}
