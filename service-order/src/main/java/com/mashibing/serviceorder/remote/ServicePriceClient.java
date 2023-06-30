package com.mashibing.serviceorder.remote;

import com.mashibing.internalcommon.dto.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 *@author js
 *@version 1.0
 */
@FeignClient("service-price")
public interface ServicePriceClient {

    @GetMapping("/price-rule/is-new")
    public ResponseResult<Boolean> isNew(@RequestParam String fareType,@RequestParam Integer fareVersion);

}