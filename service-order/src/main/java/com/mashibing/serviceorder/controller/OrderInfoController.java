package com.mashibing.serviceorder.controller;


import com.mashibing.internalcommon.constant.HeaderParamCnmstants;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.request.OrderRequest;
import com.mashibing.serviceorder.service.OrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author js
 * @since 2023-06-28
 */
@RestController
@RequestMapping("/order")
@Slf4j
@MapperScan("com.mashibing.serviceorder.mapper")
public class OrderInfoController {

    @Autowired
    OrderInfoService orderInfoService;
    /*
    * 创建订单
    * */
    @PostMapping("/add")
    public ResponseResult add(@RequestBody OrderRequest orderRequest, HttpServletRequest httpServletRequest){

        String deviceCode = httpServletRequest.getHeader(HeaderParamCnmstants.DEVICE_CODE);
        orderRequest.setDeviceCode(deviceCode);

        log.info("service-order" + orderRequest.getAddress());
        return orderInfoService.add(orderRequest);
    }


}
