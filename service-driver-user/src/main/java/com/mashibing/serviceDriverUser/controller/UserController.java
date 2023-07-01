package com.mashibing.serviceDriverUser.controller;

import com.mashibing.internalcommon.constant.DriverCarConstants;
import com.mashibing.internalcommon.dto.DriverUser;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.DriverUserExistsResponse;
import com.mashibing.internalcommon.response.OrderDriverResponse;
import com.mashibing.serviceDriverUser.service.DriverUserService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/*
 *@author js
 *@version 1.0
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private DriverUserService driverUserService;

    /*
    * 增加司机
    * */
    @PostMapping("/user")
    public ResponseResult addUser(@RequestBody DriverUser driverUser){
        log.info(JSONObject.fromObject(driverUser).toString());

        return driverUserService.addDriverUser(driverUser);

    }

    /*
    * 修改司机信息
    * */
    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody DriverUser driverUser){
        log.info(JSONObject.fromObject(driverUser).toString());

        return driverUserService.updateDriverUser(driverUser);
    }

    /*
    * 查询 司机
    * */
    @GetMapping("/check-driver/{driverPhone}")
    public ResponseResult<DriverUserExistsResponse> getUser(@PathVariable("driverPhone") String driverPhone){
        ResponseResult<DriverUser> driverUserByPhone = driverUserService.getDriverUserByPhone(driverPhone);
        DriverUser driverUserDb = driverUserByPhone.getData();

        DriverUserExistsResponse response = new DriverUserExistsResponse();
        int ifExists = DriverCarConstants.DRIVER_EXISTS;
        if(driverUserDb == null){
            ifExists = DriverCarConstants.DRIVER_NOT_EXISTS;
            response.setIfExists(ifExists);
        }else{
            response.setDriverPhone(driverUserDb.getDriverPhone());
            response.setIfExists(ifExists);
        }
        return ResponseResult.success(response);
    }

    /*
    * 根据车辆Id查询订单需要的司机信息
    * */
    @GetMapping("/get-available-driver/{carId}")
    public ResponseResult<OrderDriverResponse> getAvailableDriver(@PathVariable("carId") Long carId){
        return driverUserService.getAvailableDriver(carId);
    }


}
