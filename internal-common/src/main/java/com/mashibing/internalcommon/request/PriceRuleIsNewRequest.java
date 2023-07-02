package com.mashibing.internalcommon.request;

import lombok.Data;

/*
 *@author js
 *@version 1.0
 */
@Data
public class PriceRuleIsNewRequest {

    private String fareType;

    private Integer fareVersion;
}
