package com.mashibing.serviceprice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mashibing.internalcommon.constant.CommonStatusEnum;
import com.mashibing.internalcommon.dto.PriceRule;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.serviceprice.mapper.PriceRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author js
 *@version 1.0
 */
@Service
public class PriceRuleService {

    @Autowired
    PriceRuleMapper priceRuleMapper;

    public ResponseResult add(PriceRule priceRule){

        //拼接fareType
        String cityCode = priceRule.getCityCode();
        String vehicleType = priceRule.getVehicleType();
        String fareType = cityCode + "$" + vehicleType;
        priceRule.setFareType(fareType);

        //添加版本号
        Map<String, Object> map = new HashMap<>();
        map.put("city_code",cityCode);
        map.put("vehicle_type",vehicleType);
        //问题1：增加了版本号，前面两个字段无法唯一确定一条记录，问题2：我最大的版本号，需要排序

        QueryWrapper<PriceRule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("city_code",cityCode);
        queryWrapper.eq("vehicle_type", vehicleType);
        queryWrapper.orderByDesc("fare_version");

        List<PriceRule> priceRules = priceRuleMapper.selectList(queryWrapper);
        Integer fareVersion = 0;
        if(priceRules.size()>0){
            return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EXISTS.getCode(),CommonStatusEnum.PRICE_RULE_EXISTS.getValue());
        }
        priceRule.setFareVersion(++fareVersion);

        priceRuleMapper.insert(priceRule);
        return ResponseResult.success();

    }

    public ResponseResult edit(PriceRule priceRule){

        //拼接fareType
        String cityCode = priceRule.getCityCode();
        String vehicleType = priceRule.getVehicleType();
        String fareType = cityCode + "$" + vehicleType;
        priceRule.setFareType(fareType);


        //问题1：增加了版本号，前面两个字段无法唯一确定一条记录，问题2：我最大的版本号，需要排序

        QueryWrapper<PriceRule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("city_code",cityCode);
        queryWrapper.eq("vehicle_type", vehicleType);
        queryWrapper.orderByDesc("fare_version");

        List<PriceRule> priceRules = priceRuleMapper.selectList(queryWrapper);
        Integer fareVersion = 0;
        if(priceRules.size()>0){
            PriceRule lastPriceRules = priceRules.get(0);
            Double unitPricePerMile = lastPriceRules.getUnitPricePerMile();
            Double unitPricePerMinute = lastPriceRules.getUnitPricePerMinute();
            Double startFare = lastPriceRules.getStartFare();
            Integer startMile = lastPriceRules.getStartMile();

            if(unitPricePerMile.doubleValue() == priceRule.getUnitPricePerMile().doubleValue()
            && unitPricePerMinute.doubleValue() == priceRule.getUnitPricePerMinute().doubleValue()
            && startFare.doubleValue() == priceRule.getStartFare().doubleValue()
            && startMile.intValue() == priceRule.getStartMile().doubleValue()){
                return  ResponseResult.fail(CommonStatusEnum.PRICE_RULE_NOT_EDIT.getCode(),CommonStatusEnum.PRICE_RULE_NOT_EDIT.getValue());
            }fareVersion = lastPriceRules.getFareVersion();
        }
        priceRule.setFareVersion(++fareVersion);

        priceRuleMapper.insert(priceRule);
        return ResponseResult.success();

    }
    
    public ResponseResult getNewestVersion(String fareType){
        QueryWrapper<PriceRule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("fare_type",fareType);

        queryWrapper.orderByDesc("fare_version");

        List<PriceRule> priceRules = priceRuleMapper.selectList(queryWrapper);

        if(priceRules.size() > 0){
            return ResponseResult.success(priceRules.get(0));
        }else{
            return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EMPTY.getCode(),CommonStatusEnum.PRICE_RULE_EMPTY.getValue());
        }
    }

    public ResponseResult<Boolean> isNew(String fareType, int fareVersion){
        ResponseResult<PriceRule> newestVersionPriceRule = getNewestVersion(fareType);
        if(newestVersionPriceRule.getCode() == CommonStatusEnum.PRICE_RULE_EMPTY.getCode()){
            return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EMPTY.getCode(),CommonStatusEnum.PRICE_RULE_EMPTY.getValue());
        }

        PriceRule priceRule = newestVersionPriceRule.getData();
        Integer fareVersionDB = priceRule.getFareVersion();
        if(fareVersionDB > fareVersion){
            return ResponseResult.success(false);
        }else {
            return ResponseResult.success(true);
        }

    }
}
