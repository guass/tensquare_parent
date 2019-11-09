package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.TbPlKey;

public interface TbPlMapper {

    int deleteByPrimaryKey(TbPlKey key);


    int insert(TbPlKey record);


    int insertSelective(TbPlKey record);
}