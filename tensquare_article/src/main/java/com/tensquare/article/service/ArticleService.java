package com.tensquare.article.service;

import com.tensquare.article.dao.TbArticleMapper;
import com.tensquare.article.pojo.TbArticle;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@Service
public class ArticleService {

    @Resource
    private TbArticleMapper tbArticleMapper;

    @Resource
    private RedisTemplate redisTemplate;

    public TbArticle getArticleById(String id){
        TbArticle tbArticle = (TbArticle) redisTemplate.opsForValue().get("article_"+ id);
        if (tbArticle == null) {
            tbArticle = tbArticleMapper.selectByPrimaryKey(id);
            redisTemplate.opsForValue().set("article_"+ id,tbArticle);
        }
        return tbArticle;
    }

    /**
     * 审核
     * @param id
     */
    public void articleExamine(String id){
        TbArticle tbArticle = tbArticleMapper.selectByPrimaryKey(id);
        if (tbArticle != null) {
            tbArticle.setState("1");
            tbArticleMapper.updateByPrimaryKeySelective(tbArticle);
        }
    }


    /**
     * 点赞
     * @param id
     */
    public void articleThumbup(String id){
        TbArticle tbArticle = tbArticleMapper.selectByPrimaryKey(id);
        if (tbArticle != null) {
            Integer thumbup = tbArticle.getThumbup();
            tbArticle.setThumbup(thumbup+1);
            tbArticleMapper.updateByPrimaryKeySelective(tbArticle);
        }
    }
}
