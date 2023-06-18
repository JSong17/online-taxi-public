package com.mashibing.internalcommon.request;

import lombok.Data;

/*
 *@author js
 *@version 1.0
 */
@Data
public class ForecastPriceDTO {
    private String depLongitude;

    private String depLatitude;

    private String destLongitude;

    private String destLatitude;
}
