package com.mashibing.internalcommon.response;

import lombok.Data;

/*
 *@author js
 *@version 1.0
 */
@Data
public class ForecastPriceResponse {

    private double price;

    private String cityCode;

    private String vehicleType;
}
