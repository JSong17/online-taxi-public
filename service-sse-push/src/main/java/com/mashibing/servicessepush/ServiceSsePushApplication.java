package com.mashibing.servicessepush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
 *@author js
 *@version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceSsePushApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSsePushApplication.class,args);
    }
}
