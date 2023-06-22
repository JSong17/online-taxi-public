package com.mashibing.serviceDriverUser.service;

import com.mashibing.internalcommon.dto.DriverUser;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.serviceDriverUser.mapper.DriverUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@author js
 *@version 1.0
 */
@Service
public class DriverUserService {

    @Autowired
    private DriverUserMapper driverUserMapper;

    public ResponseResult testGetDriverUser(){
        DriverUser driverUser = driverUserMapper.selectById(1);
        return ResponseResult.success(driverUser);
    }

}
