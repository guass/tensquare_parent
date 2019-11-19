package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @PostMapping("/add-spit")
    public Result addSpit(@RequestBody Spit spit){
        spitService.add(spit);
        Result result = new Result(true, StatusCode.OK, "保存成功");
        return result;
    }

    @DeleteMapping("/delete-spit/{id}")
    public Result deleteSpit(@PathVariable String id){
        spitService.deleteById(id);
        Result result = new Result(true, StatusCode.OK, "delete成功");
        return result;
    }

    @PutMapping("/update-spit")
    public Result updateSpit(@RequestBody Spit spit){

        spitService.update(spit);
        Result result = new Result(true, StatusCode.OK, "更新成功");
        return result;
    }

    @GetMapping("/get-all-spit")
    public Result getAllSpit(){

        List<Spit> all = spitService.findAll();
        Result result = new Result(true, StatusCode.OK, "查找成功222",all);
        return result;
    }
}
