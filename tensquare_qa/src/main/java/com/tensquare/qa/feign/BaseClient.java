package com.tensquare.qa.feign;


import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("tensquare-base")
public interface BaseClient {

    @GetMapping("/lable/{lableId}")
    Result findById(@PathVariable("lableId") String lableId);
}
