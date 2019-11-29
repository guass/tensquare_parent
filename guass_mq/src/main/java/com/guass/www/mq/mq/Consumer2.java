package com.guass.www.mq.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@Component
@RabbitListener(queues = "guass_queue_2")
@Slf4j
public class Consumer2 {

    @RabbitHandler
    public void getMsg(String msg){
        log.info("guass2 msg " + msg);
    }


}
