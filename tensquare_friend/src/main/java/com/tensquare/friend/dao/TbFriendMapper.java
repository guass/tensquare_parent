package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.TbFriend;
import com.tensquare.friend.pojo.TbFriendKey;

public interface TbFriendMapper {
    
    int deleteByPrimaryKey(TbFriendKey key);

    
    int insert(TbFriend record);

    
    int insertSelective(TbFriend record);

    
    TbFriend selectByPrimaryKey(TbFriendKey key);

    
    int updateByPrimaryKeySelective(TbFriend record);

    
    int updateByPrimaryKey(TbFriend record);
}