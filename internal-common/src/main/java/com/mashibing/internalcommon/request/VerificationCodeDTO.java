package com.mashibing.apipassenger.request;

import lombok.Data;

/*
 *@author js
 *@version 1.0
 */
@Data
public class VerificationCodeDTO {

    private  String passengerPhone;

    private  String verificationCode;


}
