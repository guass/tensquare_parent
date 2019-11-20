package com.tensquare.spit.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import utils.PageUtils;
import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import lombok.extern.slf4j.Slf4j;
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


    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private IdWorker idWorker;

    @Override
    public PageInfo<Spit> findByParentId(String id, int page, int size) {

        Query query = new Query();
        query.addCriteria(Criteria.where("parentId").is(id));

        List<Spit> spitList = mongoTemplate.find(query, Spit.class, "spit");
        PageInfo<Spit> pageInfo = PageUtils.reverToPage(spitList, page, size);
        return pageInfo;
    }

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

    @Override
    public boolean thumb(String id) {
//        Spit spit = findById(id);
//        Integer thumbup = spit.getThumbup();
//        if (thumbup != null) {
//            spit.setThumbup(thumbup + 1);
//        }else {
//            spit.setThumbup(1);
//        }
//        mongoTemplate.save(spit);

        String userId = "111";

        if (redisTemplate.opsForValue().get("thumb_" + userId) != null) {
            return false;
        }
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));

        Update update = new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"spit");

        redisTemplate.opsForValue().set("thumb_" + userId,1);
        return true;
    }

}
