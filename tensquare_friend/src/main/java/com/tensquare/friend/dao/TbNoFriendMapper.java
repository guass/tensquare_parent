package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.TbNoFriendKey;

public interface TbNoFriendMapper {
    
    int deleteByPrimaryKey(TbNoFriendKey key);

    
    int insert(TbNoFriendKey record);

    
    int insertSelective(TbNoFriendKey record);
}