package com.tensquare.user.service;

import com.tensquare.user.dao.TbUserMapper;
import com.tensquare.user.pojo.TbAdmin;
import com.tensquare.user.pojo.TbUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    BCryptPasswordEncoder encoder;

    public int updateFansAndFollow(String fanId, String followId,int res){
        TbUser fan = tbUserMapper.selectByPrimaryKey(fanId);
        if (fan != null) {
            fan.setFanscount(Math.max(fan.getFanscount() + res,0));
            tbUserMapper.updateByPrimaryKeySelective(fan);
        }
        TbUser follow = tbUserMapper.selectByPrimaryKey(followId);
        if (follow != null) {
            int rr = follow.getFollowcount() + res;
            follow.setFollowcount(Math.max(rr,0));
            tbUserMapper.updateByPrimaryKeySelective(follow);
        }
        return 0;
    }


    /**
     * 发送短信
     * @param phone
     */
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
     *注册
     * @param checkCode
     */
    public int regist(String checkCode, TbUser user) {

        try {
            String code_save = (String) redisTemplate.opsForValue().get("checkCode_" + checkCode);

            if (code_save != null) {
                user.setId(idWorker.nextId() +"");
                String newPassword = encoder.encode(user.getPassword());
                user.setPassword(newPassword);
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

    public TbUser findByPhoneAndPassword(String phone, String password) {
        TbUser user = tbUserMapper.selectByPhone(phone);
        boolean matches = encoder.matches(password, user.getPassword());
        if (matches) {
            return user;
        }
        return null;
    }
}
