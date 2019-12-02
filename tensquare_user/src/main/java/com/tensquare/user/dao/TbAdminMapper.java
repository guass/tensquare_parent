package com.tensquare.user.dao;

import com.tensquare.user.pojo.TbAdmin;
import org.apache.ibatis.annotations.Param;

public interface TbAdminMapper {
    
    int deleteByPrimaryKey(String id);

    
    int insert(TbAdmin record);

    
    int insertSelective(TbAdmin record);

    
    TbAdmin selectByPrimaryKey(String id);

    TbAdmin selectByNameAndPassword(@Param("loginName") String loginName);

    
    int updateByPrimaryKeySelective(TbAdmin record);

    
    int updateByPrimaryKey(TbAdmin record);
}