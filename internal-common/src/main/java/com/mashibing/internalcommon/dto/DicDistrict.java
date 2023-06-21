package com.mashibing.internalcommon.dto;

import lombok.Data;

/*
 *@author js
 *@version 1.0
 */
@Data
public class DicDistrict {

    private String addressCode;

    private String addressName;

    private String parentAddressCode;

    private Integer level;

}
