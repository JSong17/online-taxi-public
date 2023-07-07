package com.mashibing.pay.service;

import com.mashibing.internalcommon.request.OrderRequest;
import com.mashibing.pay.remote.ServiceOrderClient;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@author js
 *@version 1.0
 */
@Service
public class AlipayService {

    @Autowired
    ServiceOrderClient serviceOrderClient;

    public void pay(Long orderId){
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderId(orderId);
        serviceOrderClient.pay(orderRequest);
    }
}
