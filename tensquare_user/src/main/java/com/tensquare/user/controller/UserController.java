package com.tensquare.user.controller;

import com.tensquare.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: guass
 * @description: user微服务
 * @data: 2019-05-28 12:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sendMsg/{phone}")
    public Result sendSms(@PathVariable String phone){

        userService.sendMsg(phone);
        Result result = new Result(true, StatusCode.OK, "send msg ok");
        return result;
    }


    @PostMapping("/regist/{checkCode}")
    public Result regist(@PathVariable String checkCode){
        userService.regist(checkCode);
        Result result = new Result(true, StatusCode.OK, "send msg ok");
        return result;
    }

}
