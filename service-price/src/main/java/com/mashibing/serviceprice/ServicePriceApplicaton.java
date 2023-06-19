package com.mashibing.serviceprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 *@author js
 *@version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServicePriceApplicaton {

    public static void main(String[] args) {
        SpringApplication.run(ServicePriceApplicaton.class);
    }
}
