package com.tensquare.base.dao;

import com.tensquare.base.pojo.TbCity;

public interface TbCityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_city
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_city
     *
     * @mbg.generated
     */
    int insert(TbCity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_city
     *
     * @mbg.generated
     */
    int insertSelective(TbCity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_city
     *
     * @mbg.generated
     */
    TbCity selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_city
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TbCity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_city
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TbCity record);
}