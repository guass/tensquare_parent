package com.tensquare.recruit.service;


import com.tensquare.recruit.dao.TbEnterpriseMapper;
import com.tensquare.recruit.pojo.TbEnterprise;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnterpriseService {

    @Resource
    private TbEnterpriseMapper tbEnterpriseMapper;

    public Result getHotEnterpriseList(){
        try {
            List<TbEnterprise> hotEnterpriseList = tbEnterpriseMapper.getHotEnterpriseList();
            Result result  = new Result(true, StatusCode.OK,"查询成功",hotEnterpriseList);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
