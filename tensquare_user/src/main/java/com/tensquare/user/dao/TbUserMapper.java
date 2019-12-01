package com.tensquare.user.dao;

import com.tensquare.user.pojo.TbUser;

public interface TbUserMapper {

    int deleteByPrimaryKey(String id);


    int insert(TbUser record);


    int insertSelective(TbUser record);


    TbUser selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(TbUser record);


    int updateByPrimaryKey(TbUser record);
}