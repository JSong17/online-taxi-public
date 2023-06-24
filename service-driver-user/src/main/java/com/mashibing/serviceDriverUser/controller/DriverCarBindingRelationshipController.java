package com.mashibing.serviceDriverUser.controller;


import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.DriverCarBindingRelationship;
import com.mashibing.serviceDriverUser.service.DriverCarBindingRelationshipMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author js
 * @since 2023-06-24
 */
@RestController
@RequestMapping("/driver-car-binding-relationship")
public class DriverCarBindingRelationshipController {

    @Autowired
    DriverCarBindingRelationshipMapperService driverCarBindingRelationshipMapperService;

    @PostMapping("/bind")
    public ResponseResult bind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship){
        return driverCarBindingRelationshipMapperService.bind(driverCarBindingRelationship);
    }

    @PostMapping("/unbind")
    public ResponseResult unbind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship){
        return driverCarBindingRelationshipMapperService.unbind(driverCarBindingRelationship);
    }

}
