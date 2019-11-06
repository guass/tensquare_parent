package com.tensquare.base.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tensquare.base.dao.TbLabelMapper;
import com.tensquare.base.pojo.TbLabel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.IdWorker;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class LabelService {

    @Resource
    private TbLabelMapper tbLabelMapper;

    @Resource
    private IdWorker idWorker;


    public TbLabel findById(String id){
        TbLabel tbLabel = tbLabelMapper.selectByPrimaryKey(id);
        return tbLabel;

    }


    public void save2(TbLabel tbLabel){
        tbLabel.setId(idWorker.nextId() +"");
        tbLabelMapper.insertSelective(tbLabel);
    }



    public void deleteById(String id){
        tbLabelMapper.deleteByPrimaryKey(id);
    }


    public PageInfo getAllLabels(TbLabel lable, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<TbLabel> tbLabels = tbLabelMapper.selectListLabel(null, null);
        PageInfo<TbLabel> pageInfo = new PageInfo<TbLabel>(tbLabels);
        return pageInfo;
    }
}
