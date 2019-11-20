package com.tensquare.spit.service.impl;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.IdWorker;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@Service("SpitServiceMongoTempImpl")
@Transactional
@Slf4j
public class SpitServiceMongoTempImpl implements SpitService {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    private IdWorker idWorker;

    @Override
    public List<Spit> findAll(){
        List<Spit> all = mongoTemplate.findAll(Spit.class);

        log.info("guass all " + all);

        return all;
    }

    @Override
    public Spit findById(String id){
        return  mongoTemplate.findById(id, Spit.class);
    }


    @Override
    public void add(Spit spit){
        spit.set_id(idWorker.nextId() +"");
        mongoTemplate.save(spit);
    }

    @Override
    public void update(Spit spit){
        mongoTemplate.save(spit);
    }

    @Override
    public void deleteById(String id){
        mongoTemplate.remove(id);
    }
}
