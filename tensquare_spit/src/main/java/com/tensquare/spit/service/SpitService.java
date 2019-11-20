package com.tensquare.spit.service;

import com.github.pagehelper.PageInfo;
import com.tensquare.spit.pojo.Spit;

import java.util.List;

public interface SpitService {

    PageInfo<Spit> findByParentId(String id, int page, int size);

    List<Spit> findAll();

    Spit findById(String id);

    void add(Spit spit);

    void update(Spit spit);

    void deleteById(String id);

    boolean thumb(String id);
}
