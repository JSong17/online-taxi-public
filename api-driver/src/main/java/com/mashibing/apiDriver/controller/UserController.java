package com.mashibing.apiDriver.controller;

import com.alibaba.nacos.api.naming.pojo.healthcheck.impl.Http;
import com.mashibing.apiDriver.service.UserService;
import com.mashibing.internalcommon.dto.*;
import com.mashibing.internalcommon.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @PostMapping("/driver-user-work-status")
    public ResponseResult changeWorkStatus(@RequestBody DriverUserWorkStatus driverUserWorkStatus){
        return userService.changeWorkStatus(driverUserWorkStatus);
    }

    /**
     * 根据司机token查询 司机和车辆的绑定关系
     * @param request
     * @return
     */
    @GetMapping("/driver-car-binding-relationship")
    public ResponseResult<DriverCarBindingRelationship> getDriverCarRelationShip(HttpServletRequest request){

        String authorization = request.getHeader("Authorization");
        TokenResult tokenResult = JwtUtils.checkToken(authorization);
        String driverPhone = tokenResult.getPhone();
        return userService.getDriverCarRelationShip(driverPhone);
    }
}
