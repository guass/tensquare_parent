package com.tensquare.user.pojo;

public class TbFollowKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_follow.userid
     *
     * @mbg.generated
     */
    private String userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_follow.targetuser
     *
     * @mbg.generated
     */
    private String targetuser;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_follow.userid
     *
     * @return the value of tb_follow.userid
     *
     * @mbg.generated
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_follow.userid
     *
     * @param userid the value for tb_follow.userid
     *
     * @mbg.generated
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_follow.targetuser
     *
     * @return the value of tb_follow.targetuser
     *
     * @mbg.generated
     */
    public String getTargetuser() {
        return targetuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_follow.targetuser
     *
     * @param targetuser the value for tb_follow.targetuser
     *
     * @mbg.generated
     */
    public void setTargetuser(String targetuser) {
        this.targetuser = targetuser == null ? null : targetuser.trim();
    }
}