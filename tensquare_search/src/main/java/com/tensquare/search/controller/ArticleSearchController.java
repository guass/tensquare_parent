package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleSearchService;
import entity.Result;
import entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/search")
public class ArticleSearchController {

    @Autowired
    private ArticleSearchService articleSearchService;

    @PostMapping("/add-search")
    public Result add(@RequestBody Article article){

        articleSearchService.add(article);
        log.info("guass "+ article);
        return new Result(true, StatusCode.OK,"add ok");
    }
}
