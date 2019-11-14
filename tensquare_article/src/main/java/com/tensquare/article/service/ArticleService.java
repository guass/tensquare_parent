package com.tensquare.article.service;

import com.tensquare.article.dao.TbArticleMapper;
import com.tensquare.article.pojo.TbArticle;
import org.springframework.stereotype.Service;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@Service
public class ArticleService {

    private TbArticleMapper tbArticleMapper;

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
