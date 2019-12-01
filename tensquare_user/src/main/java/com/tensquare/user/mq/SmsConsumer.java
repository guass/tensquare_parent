package com.tensquare.user.mq;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "guass_queue_3")
@Slf4j
public class SmsConsumer {


    @RabbitHandler
    public void getMsg(Map<String,String> map){

        log.info("guass map " + JSON.toJSONString(map));
    }
}
