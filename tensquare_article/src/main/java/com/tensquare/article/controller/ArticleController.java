package com.tensquare.article.controller;

import com.tensquare.article.service.ArticleService;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/get-article/{id}")
    public Result getArticleById(@PathVariable("id")  @NotBlank String id){
        articleService.getArticleById(id);
        Result result = new Result(true, StatusCode.OK,"审核成功",null);
        return result;
    }

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
