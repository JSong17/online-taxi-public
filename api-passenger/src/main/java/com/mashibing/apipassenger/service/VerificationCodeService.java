package com.mashibing.apipassenger.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mashibing.apipassenger.remote.ServicePassengerUserClient;
import com.mashibing.apipassenger.remote.ServiceVerificationcodeClient;
import com.mashibing.internalcommon.constant.CommonStatusEnum;
import com.mashibing.internalcommon.constant.IdentityConstant;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.request.VerificationCodeDTO;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import com.mashibing.internalcommon.response.TokenResponse;
import com.mashibing.internalcommon.util.JwtUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/*
 *@author js
 *@version 1.0
 */
@Service
public class VerificationCodeService {

    @Autowired
    private ServiceVerificationcodeClient serviceVerificationcodeClient;

    //乘客验证码的前缀
    private String verificationCodePrefix = "passenger-verification-code-";

    //token存储的前缀
    private String tokenPrefix = "token-";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /*
    * 生成验证码
    * */
    public ResponseResult generatorCode(String passengerPhone){
        //调用验证码服务，获取验证码
        System.out.println("调用验证码服务，获取验证码");
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(5);
        int numberCode = numberCodeResponse.getData().getNumberCode();

        System.out.println("remote number code:" + numberCode);

        //存入redis
        System.out.println("存入redis");

        //key,value,过期时间
        String key = generatorKeyByPhone(passengerPhone);

        //存入redis
        stringRedisTemplate.opsForValue().set(key, numberCode+"",2, TimeUnit.MINUTES);


        return  ResponseResult.success("");
    }

    /*
    * 根据手机号，生成key
    * */
    private String generatorKeyByPhone(String passengerPhone){
        return verificationCodePrefix + passengerPhone;
    }


    /*
    * 根据手机号何身份标识，生成token
    * */
    private String generatorTokenKey(String phone,String identity){
        return  tokenPrefix + phone + "-" + identity;
    }



    @Autowired
    private ServicePassengerUserClient servicePassengerUserClient;

    /*
    * 校验验证码
    * */
    public ResponseResult checkCode(String passengerPhone, String verificationCode) {

        //根据手机号，去redis读取验证码
        //生成key
        String key = generatorKeyByPhone(passengerPhone);

        //根据key获取value
        String codeRedis = stringRedisTemplate.opsForValue().get(key);
        System.out.println("redis中的value: "  + codeRedis);

        //校验验证码
        if(StringUtils.isBlank(codeRedis)){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        if(!verificationCode.trim().equals(codeRedis.trim())){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }

        //判断原来是否有用户，并进行对应的处理
        VerificationCodeDTO verificationCodeDTO = new VerificationCodeDTO();
        verificationCodeDTO.setPassengerPhone(passengerPhone);
        servicePassengerUserClient.loginOrRegister(verificationCodeDTO);

        //颁发令牌
        String token = JwtUtils.generatorToken(passengerPhone, IdentityConstant.PASSENGER_IDENTITY);

        //将token存储到redis当中
        String tokenKey = generatorTokenKey(passengerPhone, IdentityConstant.PASSENGER_IDENTITY);
        stringRedisTemplate.opsForValue().set(token,token,30,TimeUnit.DAYS);

        //响应
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);
        return ResponseResult.success(tokenResponse); 

    }
}
