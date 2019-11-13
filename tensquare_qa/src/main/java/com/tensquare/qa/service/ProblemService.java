package com.tensquare.qa.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<TbProblem> getNewProblemList(String lableId, int page , int size){
        PageHelper.startPage(page,size);
        List<TbProblem> problemListByLableId = tbProblemMapper.getProblemListByLableId(lableId);
        PageInfo<TbProblem> pageInfo = new PageInfo<TbProblem>(problemListByLableId);
        return pageInfo;
    }

    /**
     * 热门回答
     * @return
     */
    public PageInfo<TbProblem> getHotProblemList(String labeId,int page, int size){
        PageHelper.startPage(page,size);
        List<TbProblem> hotProblemListByLableId = tbProblemMapper.getHotProblemListByLableId(labeId);
        PageInfo<TbProblem> pageInfo = new PageInfo<TbProblem>(hotProblemListByLableId);
        return pageInfo;
    }

    public PageInfo<TbProblem> getWaitProblemList(String lableId,int page, int size){

        PageHelper.startPage(page,size);
        List<TbProblem> waitProblemListByLableId = tbProblemMapper.getHotProblemListByLableId(lableId);
        PageInfo<TbProblem> pageInfo = new PageInfo<TbProblem>(waitProblemListByLableId);
        return pageInfo;
    }
}
