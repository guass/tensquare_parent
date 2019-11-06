package com.tensquare.recruit.service;


import com.tensquare.recruit.dao.TbEnterpriseMapper;
import com.tensquare.recruit.dao.TbRecruitMapper;
import com.tensquare.recruit.pojo.TbEnterprise;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecruitService {

    @Resource
    private TbRecruitMapper tbRecruitMapper;


}
