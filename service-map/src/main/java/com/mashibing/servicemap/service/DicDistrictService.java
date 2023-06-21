package com.mashibing.servicemap.service;

import com.mashibing.internalcommon.constant.AmapConfigConstants;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.servicemap.remote.MapDicDistrictClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/*
 *@author js
 *@version 1.0
 */
@Service
@Slf4j
public class DicDistrictService {

    @Autowired
    private MapDicDistrictClient mapDicDistrictClient;

    public ResponseResult initDicDistrict(String keywords){

        //请求地图
        String dicDistrict = mapDicDistrictClient.dicDistrict(keywords);
        System.out.println(dicDistrict);

        //解析结果

        //插入数据库


        return ResponseResult.success();
    }


}
