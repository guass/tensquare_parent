package com.tensquare.qa.service;

import com.tensquare.qa.dao.TbProblemMapper;
import com.tensquare.qa.pojo.TbProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProblemService {

    @Resource
    private TbProblemMapper tbProblemMapper;

    /**
     *
     * @return
     */
    public List<TbProblem> getNewProblemList(){

        return null;
    }

    /**
     * 热门回答
     * @return
     */
    public List<TbProblem> getHotProblemList(){

        return null;
    }
}
