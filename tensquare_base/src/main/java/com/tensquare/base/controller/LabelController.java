package com.tensquare.base.controller;


import com.github.pagehelper.PageInfo;
import com.tensquare.base.pojo.TbLabel;
import com.tensquare.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lable")
@RefreshScope //spring cloud bus 起作用
@Slf4j
public class LabelController {

    @Resource
    private LabelService labelService;

    @Value("${server.port}")
    private String port;

    @Value("${spring.test}")
    private String test;

    @GetMapping
    public Result findAll(){

        Result result = new Result(true, StatusCode.OK, "查找成功");
        return result;
    }

    @GetMapping("/{lableId}")
    public Result findById(@PathVariable String lableId){

        log.info("qa " + port);
        log.info("test " + test);
        Result result = new Result(true, StatusCode.OK, "查找成功1 " + port,labelService.findById(lableId));

        return result;
    }


    @PostMapping
    public Result save(@RequestBody TbLabel lable){
        labelService.save2(lable);
        Result result = new Result(true, StatusCode.OK, "保存成功");

        return result;
    }

    @PutMapping("/{lableId}")
    public Result update(@PathVariable String lableId,@RequestBody TbLabel lable){
        lable.setId(lableId);
        Result result = new Result(true, StatusCode.OK, "更新成功");
        return result;
    }

    @DeleteMapping("/{lableId}")
    public Result delete(@PathVariable String lableId){
        labelService.deleteById(lableId);
        Result result = new Result(true, StatusCode.OK, "删除成功");
        return result;
    }


    @GetMapping("/search")
    public Result search(@RequestBody TbLabel lable){
        Result result = new Result(true, StatusCode.OK, "删除成功");
        return result;
    }


    @GetMapping("/get-all-lables/{page}/{size}")
    public PageInfo<TbLabel> getAllLableList(@RequestBody TbLabel lable,
                                             @PathVariable Integer page, @PathVariable Integer size){
        PageInfo allLabels = labelService.getAllLabels(lable, page, size);
        return allLabels;
    }
}
