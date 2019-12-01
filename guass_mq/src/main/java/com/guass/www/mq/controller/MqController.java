package com.guass.www.mq.controller;

import com.oracle.tools.packager.Log;
import entity.Result;
import entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/mq")
@Slf4j
public class MqController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("/send-msg")
    public Result sendMq(){
        rabbitTemplate.convertAndSend("guass_topic","guass3.abc","222222");
        return new Result(true, StatusCode.OK,"ok");
    }
}
