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
@RequestMapping("/recruit")
public class RecruitController {

    @Resource
    private RecruitService recruitService;


    @GetMapping("/get-recommed-list")
    public Result getRecommendRecruitList(){

        Result list = recruitService.getList();
        return list;
    }

    @GetMapping("/get-new-list")
    public Result getNewRecruitList(){

        return recruitService.getList();
    }
}
