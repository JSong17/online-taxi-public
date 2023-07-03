package com.mashibing.apipassenger.controller;

import com.mashibing.apipassenger.remote.ServiceOrderClient;
import com.mashibing.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    ServiceOrderClient serviceOrderClient;

    @GetMapping("/test-real-time-order/{orderId}")
    public String dispatchRealTimeOrder(@PathVariable("orderId") long orderId) {
        System.out.println("并发测试：orderId：" + orderId);
        serviceOrderClient.dispatchRealTimeOrder(orderId);
        return "test-real-time-order success";
    }






}
