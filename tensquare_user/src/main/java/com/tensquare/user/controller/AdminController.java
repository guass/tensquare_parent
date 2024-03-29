package com.tensquare.user.controller;

import utils.JwtUtil;
import com.tensquare.user.pojo.TbAdmin;
import com.tensquare.user.service.AdminService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/admin")
@Api(tags = "admin操作接口")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Resource
    private JwtUtil jwtUtil;


    @ApiOperation("admin login接口")
    @PostMapping("/login")
    public Result login(@RequestBody Map<String,String> loginMap){

        TbAdmin admin = adminService.findByLoginNameAndPassword(loginMap.get("login_name"),
                loginMap.get("password"));

        if (admin != null) {
            String token = jwtUtil.createJWT(admin.getId(), admin.getLoginname(), "admin");
            Map<String,String> map = new HashMap<>();
            map.put("token",token);
            map.put("name",admin.getLoginname());
            return new Result(true, StatusCode.OK,"login ok",map);
        }
        return new Result(true, StatusCode.ERROR,"login err! user not exist");
    }
}
