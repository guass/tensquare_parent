package com.tensquare.article.dao;

import com.tensquare.article.pojo.TbChannel;

public interface TbChannelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_channel
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_channel
     *
     * @mbg.generated
     */
    int insert(TbChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_channel
     *
     * @mbg.generated
     */
    int insertSelective(TbChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_channel
     *
     * @mbg.generated
     */
    TbChannel selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_channel
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TbChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_channel
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TbChannel record);
}