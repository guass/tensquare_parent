package com.tensquare.spit.service;

import com.tensquare.spit.pojo.Spit;

import java.util.List;

public interface SpitService {

    List<Spit> findAll();

    Spit findById(String id);

    void add(Spit spit);

    void update(Spit spit);

    void deleteById(String id);
}
