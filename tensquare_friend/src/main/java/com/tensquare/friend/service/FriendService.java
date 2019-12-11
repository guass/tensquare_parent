package com.tensquare.friend.service;

public interface FriendService {

    int addFriend(String userId, String friendId);

    int addNoFriend(String userId, String friendId);


}
