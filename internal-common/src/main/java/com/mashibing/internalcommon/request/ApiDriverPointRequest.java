package com.mashibing.internalcommon.request;

import com.mashibing.internalcommon.dto.PointDTO;
import lombok.Data;

/*
 *@author js
 *@version 1.0
 */
@Data
public class ApiDriverPointRequest {

    public Long carId;

    private PointDTO[] points;

}
