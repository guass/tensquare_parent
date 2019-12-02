package com.tensquare.user.pojo;

public class TbFollowKey {
    
    private String userid;

    
    private String targetuser;

    
    public String getUserid() {
        return userid;
    }

    
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    
    public String getTargetuser() {
        return targetuser;
    }

    
    public void setTargetuser(String targetuser) {
        this.targetuser = targetuser == null ? null : targetuser.trim();
    }
}