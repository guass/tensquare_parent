package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@Service
public class ArticleSearchService {

    @Resource
    private ArticleSearchDao articleSearchDao;

    public void add(Article article){
        articleSearchDao.save(article);
    }

}
