package com.mashibing.serviceorder.service;

import com.mashibing.internalcommon.dto.OrderInfo;
import com.mashibing.serviceorder.mapper.OrderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@author js
 *@version 1.0
 */
@Service
public class OrderService {

    @Autowired
    OrderInfoMapper orderInfoMapper;
    public String testmapper(){
        OrderInfo o = new OrderInfo();
        o.setAddress("110000");
        orderInfoMapper.insert(o);
        return "";
    }

}
