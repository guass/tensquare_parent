package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.TbNoFriendKey;
import org.apache.ibatis.annotations.Param;

public interface TbNoFriendMapper {
    
    int deleteByPrimaryKey(TbNoFriendKey key);

    
    int insert(TbNoFriendKey record);

    
    int insertSelective(TbNoFriendKey record);

    TbNoFriendKey selectInfo(@Param("userId") String userId, @Param("friendId") String friendId);
}