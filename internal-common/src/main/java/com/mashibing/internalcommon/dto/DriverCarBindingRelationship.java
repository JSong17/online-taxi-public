package com.mashibing.internalcommon.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 * @author js
 * @since 2023-06-24
 */
@Data
public class DriverCarBindingRelationship implements Serializable {


    private Long id;

    private Long driverId;

    private Long carId;

    private Integer bindState;

    private LocalDateTime bindingTime;

    private LocalDateTime unBindingTime;


}
