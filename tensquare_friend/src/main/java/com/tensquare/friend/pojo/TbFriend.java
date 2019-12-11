package com.tensquare.friend.pojo;

public class TbFriend extends TbFriendKey {
    
    private String islike;

    
    public String getIslike() {
        return islike;
    }

    
    public void setIslike(String islike) {
        this.islike = islike == null ? null : islike.trim();
    }
}