package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.TbProblem;

import java.util.List;

public interface TbProblemMapper {

    int deleteByPrimaryKey(String id);


    int insert(TbProblem record);


    int insertSelective(TbProblem record);


    TbProblem selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(TbProblem record);


    int updateByPrimaryKeyWithBLOBs(TbProblem record);


    int updateByPrimaryKey(TbProblem record);

    List<TbProblem> getProblemListByLableId(String lableId);

    List<TbProblem> getHotProblemListByLableId(String lableId);

    List<TbProblem> getWaitProblemListByLableId(String lableId);
}