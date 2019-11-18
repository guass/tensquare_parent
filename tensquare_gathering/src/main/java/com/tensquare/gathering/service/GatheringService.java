package com.tensquare.gathering.service;

import com.tensquare.gathering.dao.TbGatheringMapper;
import com.tensquare.gathering.pojo.TbGatheringWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import utils.IdWorker;

import javax.annotation.Resource;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@Service
public class GatheringService {

    @Resource
    private TbGatheringMapper tbGatheringMapper;

    @Resource
    private IdWorker idWorker;

    public void add(TbGatheringWithBLOBs tbGatheringWithBLOBs){
        long id = idWorker.nextId();
        tbGatheringWithBLOBs.setId(id+"");
        tbGatheringMapper.insertSelective(tbGatheringWithBLOBs);
    }

    @Cacheable(value = "gathering", key = "#id")
    public TbGatheringWithBLOBs getGathering(String id){
        TbGatheringWithBLOBs tbGatheringWithBLOBs = tbGatheringMapper.selectByPrimaryKey(id);
        return tbGatheringWithBLOBs;
    }

    /**
     * update
     * @param tbGatheringWithBLOBs
     */
    @CacheEvict(value = "gathering", key = "#tbGatheringWithBLOBs.id")
    public void updateGathering(TbGatheringWithBLOBs tbGatheringWithBLOBs){
        TbGatheringWithBLOBs gathering = tbGatheringMapper.selectByPrimaryKey(tbGatheringWithBLOBs.getId());
        if (gathering != null) {
            gathering.setDetail(tbGatheringWithBLOBs.getDetail());
            gathering.setSummary(tbGatheringWithBLOBs.getSummary());
            gathering.setAddress(tbGatheringWithBLOBs.getAddress());
            gathering.setCity(tbGatheringWithBLOBs.getCity());
            gathering.setEndtime(tbGatheringWithBLOBs.getEndtime());
            gathering.setSponsor(tbGatheringWithBLOBs.getSponsor());
            gathering.setEnrolltime(tbGatheringWithBLOBs.getEnrolltime());
            gathering.setImage(tbGatheringWithBLOBs.getImage());
            gathering.setStarttime(tbGatheringWithBLOBs.getStarttime());
            gathering.setState(tbGatheringWithBLOBs.getState());

            tbGatheringMapper.updateByPrimaryKeySelective(gathering);
        }
    }

    @CacheEvict(value = "gathering", key = "#id")
    public void delete(String id){
        tbGatheringMapper.deleteByPrimaryKey(id);
    }
}
