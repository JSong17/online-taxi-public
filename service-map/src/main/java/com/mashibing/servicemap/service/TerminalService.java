package com.mashibing.servicemap.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.servicemap.remote.TerminalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@author js
 *@version 1.0
 */
@Service
public class TerminalService {

    @Autowired
    TerminalClient terminalClient;

    public ResponseResult add(String name){
        return terminalClient.add(name);
    }

}
