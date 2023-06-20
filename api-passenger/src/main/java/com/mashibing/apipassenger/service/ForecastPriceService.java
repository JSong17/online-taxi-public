package com.mashibing.apipassenger.service;

import com.mashibing.apipassenger.remote.ServicePriceClient;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.request.ForecastPriceDTO;
import com.mashibing.internalcommon.response.ForecastPriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@author js
 *@version 1.0
 */
@Service
@Slf4j
public class ForecastPriceService {

    @Autowired
    ServicePriceClient servicePriceClient;


    /*
    * 根据 出发地和目的地经纬度 计算预估价格
    * */
    public ResponseResult forecastPrice(String depLongitude, String depLatitude, String destLongitude, String destLatitude){

        log.info("出发地精度： " + depLongitude);
        log.info("出发地纬度： " + depLatitude);
        log.info("目的地精度： " + destLongitude);
        log.info("目的地纬度： " + destLatitude);

        log.info("调用计算服务，计算价格");
        ForecastPriceDTO forecastPriceDTO = new ForecastPriceDTO();
        forecastPriceDTO.setDepLongitude(depLongitude);
        forecastPriceDTO.setDepLatitude(depLatitude);
        forecastPriceDTO.setDestLongitude(destLongitude);
        forecastPriceDTO.setDestLatitude(destLatitude);
        ResponseResult<ForecastPriceResponse> forecast = servicePriceClient.forecast(forecastPriceDTO);
        double price = forecast.getData().getPrice();


        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(price);
        return ResponseResult.success(forecastPriceResponse);
    }

}
