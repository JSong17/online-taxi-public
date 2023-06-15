package com.mashibing.internalcommon.response;

import lombok.Data;

/*
 *@author js
 *@version 1.0
 */
@Data
public class TokenResponse {

    private String accessToken;

    private String refreshToken;
}
