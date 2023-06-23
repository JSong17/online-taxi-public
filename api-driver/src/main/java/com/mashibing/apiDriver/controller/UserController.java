package com.mashibing.apiDriver.controller;

import com.mashibing.apiDriver.service.UserService;
import com.mashibing.internalcommon.dto.DriverUser;
import com.mashibing.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 *@author js
 *@version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /*
     * 修改司机
     * */
    @PutMapping("/user")
    public ResponseResult updateDriverUser(@RequestBody DriverUser driverUser){
        return userService.updateDriverUser(driverUser);
    }
}
