package com.tensquare.recruit.controller;


import com.tensquare.recruit.service.RecruitService;
import entity.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/Enterprise")
public class EnterpriseController {

    @Resource
    private RecruitService recruitService;

    @GetMapping("/get-hotent-list")
    public Result getHotList(){
        return recruitService.getHotEnterpriseList();
    }
}
