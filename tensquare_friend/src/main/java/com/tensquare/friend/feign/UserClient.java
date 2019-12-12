package com.tensquare.friend.feign;

import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@FeignClient("tensquare-user")
public interface UserClient {

    @PutMapping("/friend/update/fans/follow/{fansId}/{followId}/{res}")
    Result updateFansAndFollow(@PathVariable("fansId") String fansId, @PathVariable("followId") String followId, @PathVariable("res") Integer res);
}
