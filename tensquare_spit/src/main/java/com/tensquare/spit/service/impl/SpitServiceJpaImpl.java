package com.tensquare.spit.service.impl;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@Slf4j
@Service("SpitServiceJpaImpl")
@Transactional
public class SpitServiceJpaImpl implements SpitService {

    @Autowired
    private SpitDao spitDao;

    @Override
    public List<Spit> findAll() {
        log.info("guass findAll " );
        return spitDao.findAll();
    }

    @Override
    public Spit findById(String id) {
        return spitDao.findById(id).get();
    }

    @Override
    public void add(Spit spit) {
        spitDao.save(spit);
    }

    @Override
    public void update(Spit spit) {
        spitDao.save(spit);
    }

    @Override
    public void deleteById(String id) {
        spitDao.deleteById(id);
    }
}
