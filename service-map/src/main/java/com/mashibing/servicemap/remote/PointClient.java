package com.mashibing.servicemap.remote;

import cn.hutool.core.util.URLUtil;
import com.mashibing.internalcommon.constant.AmapConfigConstants;
import com.mashibing.internalcommon.dto.PointDTO;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.request.PointRequest;
import com.mashibing.internalcommon.response.TrackResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/*
 *@author js
 *@version 1.0
 */
@Service
public class PointClient {

    @Value("${amap.key}")
    private String amapKey;

    @Value("${amap.sid}")
    private String amapSid;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseResult upload(PointRequest pointRequest){


        //组装请求的url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.POINT_UPLOAD);
        url.append("?");
        url.append("key="+amapKey);
        url.append("&");
        url.append("sid=" + amapSid);
        url.append("&");
        url.append("tid=" + pointRequest.getTid());
        url.append("&");
        url.append("trid=" + pointRequest.getTrid());
        url.append("&");
        url.append("points=");
        PointDTO[] points = pointRequest.getPoints();
        url.append("%5B");

        String normalize = URLUtil.normalize(url.toString());

        for (PointDTO p : points) {
            url.append("%7B");
            String locatetime = p.getLocatetime();
            String location = p.getLocation();
            url.append("%22location%22");
            url.append("%3A");
            url.append("%22" + location + "%22");
            url.append("%2C");

            url.append("%22locatetime%22");
            url.append("%3A");
            url.append(locatetime);

            url.append("%7D");
        }
        url.append("%5D");

        System.out.println("高德地图请求：" + url.toString());

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(URI.create(url.toString()), null, String.class);
        System.out.println("高德地图响应："+ stringResponseEntity.getBody());

        return ResponseResult.success();

    }


}
