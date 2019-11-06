package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.TbEnterprise;

import java.util.List;

public interface TbEnterpriseMapper {

    int deleteByPrimaryKey(String id);

    int insert(TbEnterprise record);

    int insertSelective(TbEnterprise record);


    TbEnterprise selectByPrimaryKey(String id);

    List<TbEnterprise> getHotEnterpriseList();

    int updateByPrimaryKeySelective(TbEnterprise record);

    int updateByPrimaryKey(TbEnterprise record);
}