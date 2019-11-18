package com.tensquare.gathering.dao;

import com.tensquare.gathering.pojo.TbGathering;
import com.tensquare.gathering.pojo.TbGatheringWithBLOBs;

public interface TbGatheringMapper {
    
    int deleteByPrimaryKey(String id);

    
    int insert(TbGatheringWithBLOBs record);

    
    int insertSelective(TbGatheringWithBLOBs record);

    
    TbGatheringWithBLOBs selectByPrimaryKey(String id);

    
    int updateByPrimaryKeySelective(TbGatheringWithBLOBs record);

    
    int updateByPrimaryKeyWithBLOBs(TbGatheringWithBLOBs record);

    
    int updateByPrimaryKey(TbGathering record);
}