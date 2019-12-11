package com.tensquare.friend.service.impl;

import com.tensquare.friend.dao.TbFriendMapper;
import com.tensquare.friend.dao.TbNoFriendMapper;
import com.tensquare.friend.pojo.TbFriend;
import com.tensquare.friend.pojo.TbFriendKey;
import com.tensquare.friend.pojo.TbNoFriendKey;
import com.tensquare.friend.service.FriendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@Service
public class FriendServiceImpl implements FriendService {

    @Resource
    private TbFriendMapper tbFriendMapper;

    @Resource
    private TbNoFriendMapper tbNoFriendMapper;

    @Override
    public int addFriend(String userId, String friendId) {
        TbFriendKey tbFriendKey = new TbFriendKey();
        tbFriendKey.setUserid(userId);
        tbFriendKey.setFriendid(friendId);

        TbFriendKey tbFriendKey2 = new TbFriendKey();
        tbFriendKey.setUserid(friendId);
        tbFriendKey.setFriendid(userId);

        TbFriend tbFriend = tbFriendMapper.selectByPrimaryKey(tbFriendKey);
        TbFriend tbFriend2 = tbFriendMapper.selectByPrimaryKey(tbFriendKey2);

        if (tbFriend == null) {
            tbFriend = new TbFriend();
            tbFriend.setUserid(userId);
            tbFriend.setFriendid(friendId);
            if (tbFriend2 != null) {
                tbFriend.setIslike(0 +"");
            }else {
                tbFriend.setIslike(1 +"");
            }
            tbFriendMapper.insertSelective(tbFriend);
        }else {
            return -1;
        }

        return 0;
    }

    @Override
    public int addNoFriend(String userId, String friendId) {
        TbNoFriendKey tbNoFriendKey = tbNoFriendMapper.selectInfo(userId, friendId);
        if (tbNoFriendKey == null) {
            tbNoFriendKey.setUserId(userId);
            tbNoFriendKey.setFriendId(friendId);
            tbNoFriendMapper.insertSelective(tbNoFriendKey);
            return 0;
        }

        return -1;
    }
}
