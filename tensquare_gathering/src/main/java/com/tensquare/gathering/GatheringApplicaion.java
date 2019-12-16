package com.tensquare.gathering;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import utils.IdWorker;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@SpringBootApplication
@MapperScan(value = "com.tensquare.gathering.dao")
@EnableCaching
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class GatheringApplicaion {

    public static void main(String[] args) {
        SpringApplication.run(GatheringApplicaion.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
