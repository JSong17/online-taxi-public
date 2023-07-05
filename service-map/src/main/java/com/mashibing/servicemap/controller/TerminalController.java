package com.mashibing.servicemap.controller;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.TerminalResponse;
import com.mashibing.servicemap.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *@author js
 *@version 1.0
 */
@RestController
@RequestMapping("/terminal")
public class TerminalController {

    @Autowired
    private TerminalService terminalService;

    @PostMapping("/add")
    public ResponseResult<TerminalResponse> add(String name, String desc){
        return terminalService.add(name,desc);
    }

    @PostMapping("/aroundsearch")
    public ResponseResult<List<TerminalResponse>> aroundsearch(String center, Integer radius){
        return terminalService.aroundsearch(center,radius);
    }

    @PostMapping("/trsearch")
    public ResponseResult trsearch(String tid,Long starttime,Long endtime){
        return terminalService.trsearch(tid,starttime,endtime);
    }

}
