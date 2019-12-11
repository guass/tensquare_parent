package com.tensquare.friend.pojo;

public class TbFriendKey {
    
    private String userid;

    
    private String friendid;

    
    public String getUserid() {
        return userid;
    }

    
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    
    public String getFriendid() {
        return friendid;
    }

    
    public void setFriendid(String friendid) {
        this.friendid = friendid == null ? null : friendid.trim();
    }
}