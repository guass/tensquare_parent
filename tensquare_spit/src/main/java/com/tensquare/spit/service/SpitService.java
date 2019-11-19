package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.IdWorker;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@Service
@Transactional
public class SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    private IdWorker idWorker;

    public List<Spit> findAll(){
        List<Spit> all = mongoTemplate.findAll(Spit.class);

//        return spitDao.findAll();
        return all;
    }

    public Spit findById(String id){
        Spit spit = mongoTemplate.findById(id, Spit.class);

        Spit spit1 = spitDao.findById(id).get();

        return spit;
    }


    public void add(Spit spit){
        spit.set_id(idWorker.nextId() +"");
//        mongoTemplate.save(spit);
        spitDao.save(spit);
    }

    public void update(Spit spit){
//        mongoTemplate.save(spit);
        spitDao.save(spit);
    }

    public void deleteById(String id){
        spitDao.deleteById(id);
    }
}
