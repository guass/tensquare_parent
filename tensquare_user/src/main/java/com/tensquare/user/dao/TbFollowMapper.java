package com.tensquare.user.dao;

import com.tensquare.user.pojo.TbFollowKey;

public interface TbFollowMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_follow
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(TbFollowKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_follow
     *
     * @mbg.generated
     */
    int insert(TbFollowKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_follow
     *
     * @mbg.generated
     */
    int insertSelective(TbFollowKey record);
}