package com.tensquare.base.dao;

import com.tensquare.base.pojo.TbLabel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbLabelMapper {

    int deleteByPrimaryKey(String id);


    int insert(TbLabel record);


    int insertSelective(TbLabel record);


    TbLabel selectByPrimaryKey(String id);

    List<TbLabel> selectListLabel(@Param("page") Integer page, @Param("size")Integer size);

    int updateByPrimaryKeySelective(TbLabel record);

    int updateByPrimaryKey(TbLabel record);
}