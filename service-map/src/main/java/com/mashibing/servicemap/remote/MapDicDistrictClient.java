package com.mashibing.servicemap.remote;

import com.mashibing.internalcommon.constant.AmapConfigConstants;
import com.mashibing.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 *@author js
 *@version 1.0
 */
@Service
public class MapDicDistrictClient {

    @Value("${amap.key}")
    private String amapKey;

    @Autowired
    private RestTemplate restTemplate;

    public String dicDistrict(String keywords){
        //组装请求的url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.DISTRICT_URL);
        url.append("?");
        url.append("keywords=" + keywords);
        url.append("&");
        url.append("subdistrict=3");
        url.append("&");
        url.append("key="+amapKey);

        ResponseEntity<String> forEntity = restTemplate.getForEntity(url.toString(), String.class);
        //解析结果

        //插入数据库

        return forEntity.getBody();
    }


}
