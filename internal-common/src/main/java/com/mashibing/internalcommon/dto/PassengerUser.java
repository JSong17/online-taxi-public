package com.mashibing.internalcommon.dto;

import lombok.Data;

import java.time.LocalDateTime;

/*
 *@author js
 *@version 1.0
 */
@Data
public class PassengerUser {

    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private String passengerPhone;

    private String passengerName;

    private byte passengerGender;

    private byte state;

    private String profilePhoto;


}