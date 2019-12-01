package com.tensquare.user.service;

import com.tensquare.user.dao.TbUserMapper;
import com.tensquare.user.pojo.TbUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import utils.IdWorker;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
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

    @Resource
    private TbUserMapper tbUserMapper;

    @Autowired
    private IdWorker idWorker;

    public void sendMsg(String phone) {

        String randomNumeric = RandomStringUtils.randomNumeric(6);


        redisTemplate.opsForValue().set("checkCode_" + randomNumeric,randomNumeric,4, TimeUnit.MINUTES);

        Map<String,String> map = new HashMap<>();
        map.put("phone",phone);
        map.put("checkCode",randomNumeric);
        //send mq
        rabbitTemplate.convertAndSend("guass_topic","guass3.abc",map);

    }

    /**
     *
     * @param checkCode
     */
    public int regist(String checkCode, TbUser user) {

        try {
            String code_save = (String) redisTemplate.opsForValue().get("checkCode_" + checkCode);

            if (code_save != null) {
                user.setId(idWorker.nextId() +"");
                //todo add user
                tbUserMapper.insertSelective(user);
            }else {
                //todo checkCode is need update
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -2;
        }

        return 0;
    }
}
