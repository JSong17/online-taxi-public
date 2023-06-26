package com.mashibing.apiDriver.service;

import com.mashibing.apiDriver.remote.ServiceDriverUserClient;
import com.mashibing.internalcommon.dto.Car;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.request.ApiDriverPointRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@author js
 *@version 1.0
 */
@Service
public class PointService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult upload(ApiDriverPointRequest apiDriverPointRequest){
        //获取carId
        Long carId = apiDriverPointRequest.getCarId();

        //通过carId 获取tid,trid,调用 service-driver-user的接口
        ResponseResult<Car> carById = serviceDriverUserClient.getCarById(carId);
        Car car = carById.getData();
        String tid = car.getTid();
        String trid = car.getTrid();


        return null;
    }
}
