package com.mashibing.internalcommon.dto;

import com.mashibing.internalcommon.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/*
 *@author js
 *@version 1.0
 */
@Data
@Accessors(chain = true)
public class ResponseResult<T> {

    private int code;
    private String message;
    private T data;


    public static <T> ResponseResult success(){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue());
    }

    /*
    * 成功
    * */
    public  static <T> ResponseResult success(T data){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue()).setData(data);
    }

    /*
    * 失败，自定义失败 错误码，提示信息
    * */

    public  static ResponseResult fail(int code,String message){
        return new ResponseResult().setCode(code).setMessage(message);
    }

    /*
     * 失败，统一的失败
     * */
    public  static <T> ResponseResult fail(T data){
        return new ResponseResult().setData(data);
    }

    /*
     * 失败，自定义失败 错误码，提示信息，具体错误
     * */
    public  static ResponseResult fail(int code,String message, String data){
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }

}
