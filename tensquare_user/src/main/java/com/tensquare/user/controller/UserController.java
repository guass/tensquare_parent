package com.tensquare.user.controller;

import com.tensquare.user.pojo.TbAdmin;
import com.tensquare.user.pojo.TbUser;
import com.tensquare.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: guass
 * @description: user微服务
 * @data: 2019-05-28 12:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(tags = "User")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("发送短信")
    @PostMapping("/sendMsg/{phone}")
    public Result sendSms(@PathVariable String phone){

        userService.sendMsg(phone);
        Result result = new Result(true, StatusCode.OK, "send msg ok");
        return result;
    }


    @ApiOperation("用户注册")
    @PostMapping("/regist/{checkCode}")
    public Result regist(@PathVariable String checkCode, @RequestBody TbUser user){
        userService.regist(checkCode,user);
        Result result = new Result(true, StatusCode.OK, "send msg ok");
        return result;
    }

    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody Map<String,String> loginMap){

        TbUser user = userService.findByPhoneAndPassword(loginMap.get("phone"),
                loginMap.get("password"));

        if (user != null) {
            return new Result(true, StatusCode.OK,"login ok");
        }
        return new Result(true, StatusCode.ERROR,"login err! user not exist");
    }

}
