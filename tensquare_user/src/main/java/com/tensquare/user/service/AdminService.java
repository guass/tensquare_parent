package com.tensquare.user.service;

import com.tensquare.user.dao.TbAdminMapper;
import com.tensquare.user.pojo.TbAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import utils.IdWorker;

import javax.annotation.Resource;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@Service
public class AdminService {

    @Resource
    TbAdminMapper tbAdminMapper;

    @Autowired
    IdWorker idWorker;

    @Autowired
    BCryptPasswordEncoder encoder;


    public void addAdminUser(TbAdmin admin){
        admin.setId(idWorker.nextId() +"");
        String newPassowrd = encoder.encode(admin.getPassword());
        admin.setPassword(newPassowrd);
        tbAdminMapper.insertSelective(admin);
    }

    public TbAdmin findByLoginNameAndPassword(String loginName, String password){
        try {
            TbAdmin admin = tbAdminMapper.selectByNameAndPassword(loginName);
            boolean matches = encoder.matches(password, admin.getPassword());
            if (matches) {
                return admin;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
