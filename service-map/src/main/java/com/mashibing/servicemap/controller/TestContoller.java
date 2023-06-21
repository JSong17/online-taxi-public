package com.mashibing.servicemap.controller;

import com.mashibing.internalcommon.dto.DicDistrict;
import com.mashibing.servicemap.mapper.DicDistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/*
 *@author js
 *@version 1.0
 */
@RestController
public class TestContoller {


    @GetMapping("/test")
    public String test(){
        return "service map";
    }

    @Autowired
    DicDistrictMapper mapper;

    @GetMapping("/test-map")
    public String testMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("address_code","110000");
        List<DicDistrict> dicDistricts = mapper.selectByMap(map);
        System.out.println(dicDistricts);

        return "test-map";
    }
}
