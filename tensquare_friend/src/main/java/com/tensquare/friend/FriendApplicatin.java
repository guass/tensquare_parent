package com.tensquare.friend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.tensquare.friend.dao")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class FriendApplicatin {

    public static void main(String[] args) {
        SpringApplication.run(FriendApplicatin.class,args);
    }
}
