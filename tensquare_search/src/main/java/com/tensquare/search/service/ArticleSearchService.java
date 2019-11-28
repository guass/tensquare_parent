package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<Article> findByKey(String key, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return articleSearchDao.findByTitleOrContentLike(key,key,pageable);
    }
}
