package com.tensquare.article.dao;

import com.tensquare.article.pojo.TbArticle;

public interface TbArticleMapper {

    int deleteByPrimaryKey(String id);


    int insert(TbArticle record);


    int insertSelective(TbArticle record);

    TbArticle selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(TbArticle record);


    int updateByPrimaryKeyWithBLOBs(TbArticle record);


    int updateByPrimaryKey(TbArticle record);
}