package com.mashibing.servicemap.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.servicemap.remote.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@author js
 *@version 1.0
 */
@Service
public class ServiceFromMapService {

    @Autowired
    private ServiceClient serviceClient;

    /*
    * 创建服务
    * */
    public ResponseResult add(String name){
        return serviceClient.add(name);
    }

}
