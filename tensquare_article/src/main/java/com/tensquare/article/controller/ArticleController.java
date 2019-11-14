package com.tensquare.article.controller;

import com.tensquare.article.service.ArticleService;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    private ArticleService articleService;

    @PostMapping("/examine/{id}")
    public Result articleExamine(@PathVariable("id") String id){
        articleService.articleExamine(id);
        Result result = new Result(true, StatusCode.OK,"审核成功",null);
        return result;
    }

    @PostMapping("/thumb/{id}")
    public Result articleThumb(@PathVariable("id") String id){
        articleService.articleThumbup(id);
        Result result = new Result(true, StatusCode.OK,"点赞成功",null);
        return result;
    }
}
