package com.mashibing.serviceorder.remote;

import com.mashibing.internalcommon.dto.PriceRule;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.request.PriceRuleIsNewRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/*
 *@author js
 *@version 1.0
 */
@FeignClient("service-price")
public interface ServicePriceClient {

    @PostMapping("/price-rule/is-new")
    public ResponseResult<Boolean> isNew(@RequestBody PriceRuleIsNewRequest priceRuleIsNewRequest);

    @RequestMapping(method = RequestMethod.GET,value = "/price-rule/if-exists")
    public ResponseResult<Boolean> ifPriceExists(@RequestBody PriceRule priceRule);

}
