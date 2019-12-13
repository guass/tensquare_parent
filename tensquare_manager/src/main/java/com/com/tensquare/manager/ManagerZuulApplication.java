package com.com.tensquare.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ManagerZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerZuulApplication.class,args);
    }

}
