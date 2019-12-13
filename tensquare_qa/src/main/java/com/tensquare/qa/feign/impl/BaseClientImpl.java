package com.tensquare.qa.feign.impl;

import com.tensquare.qa.feign.BaseClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@Component
public class BaseClientImpl implements BaseClient {
    @Override
    public Result findById(String lableId) {
        return new Result(false, StatusCode.ERROR,"熔断........");
    }
}
