package com.mashibing.serviceDriverUser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *@author js
 *@version 1.0
 */
@SpringBootApplication
@MapperScan("com.mashibing.serviceDriverUser.mapper")
public class ServiceDriverUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDriverUserApplication.class);
    }
}
