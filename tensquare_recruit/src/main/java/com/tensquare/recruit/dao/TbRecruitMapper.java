package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.TbRecruit;

import java.util.List;

public interface TbRecruitMapper {

    int deleteByPrimaryKey(String id);


    int insert(TbRecruit record);


    int insertSelective(TbRecruit record);


    TbRecruit selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(TbRecruit record);


    int updateByPrimaryKey(TbRecruit record);

    List<TbRecruit> getList();
}