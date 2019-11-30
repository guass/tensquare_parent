package com.tensquare.user.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@Service
public class UserService {

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String phone) {

        String randomNumeric = RandomStringUtils.randomNumeric(6);


        redisTemplate.opsForValue().set("checkCode_" + randomNumeric,randomNumeric,4, TimeUnit.MINUTES);

        //send mq
        rabbitTemplate.convertAndSend("guass_topic","guass3.abc","222222");

    }
}
