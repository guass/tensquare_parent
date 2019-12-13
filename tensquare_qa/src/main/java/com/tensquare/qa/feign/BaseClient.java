package com.tensquare.qa.feign;


import com.tensquare.qa.feign.impl.BaseClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "tensquare-base", fallback = BaseClientImpl.class)
public interface BaseClient {

    @GetMapping("/base/lable/{lableId}")
    Result findById(@PathVariable("lableId") String lableId);
}
