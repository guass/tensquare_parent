package com.tensquare.recruit.service;


import com.tensquare.recruit.dao.TbEnterpriseMapper;
import com.tensquare.recruit.dao.TbRecruitMapper;
import com.tensquare.recruit.pojo.TbEnterprise;
import com.tensquare.recruit.pojo.TbRecruit;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecruitService {

    @Resource
    private TbRecruitMapper tbRecruitMapper;


    public Result getList() {

        List<TbRecruit> list = tbRecruitMapper.getList();
        Result result = new Result(true, StatusCode.OK,"查询成功",list);
        return result;
    }
}
