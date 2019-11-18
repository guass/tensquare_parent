package com.tensquare.gathering.controller;

import com.tensquare.gathering.pojo.TbGatheringWithBLOBs;
import com.tensquare.gathering.service.GatheringService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/gathering")
public class GatheringController {

    @Autowired
    GatheringService gatheringService;


    /**
     * 获取单个
     * @param id
     * @return
     */
    @GetMapping("/get-gathering/{id}")
    public Result getGathering(@PathVariable("id") String id){

        TbGatheringWithBLOBs gathering = gatheringService.getGathering(id);

        Result result = new Result(true, StatusCode.OK, "查询成功", gathering);

        return result;
    }

    /**
     * 添加活点
     * @param tbGatheringWithBLOBs
     * @return
     */
    @PostMapping("/add-gathering")
    public Result addGathering(@RequestBody TbGatheringWithBLOBs tbGatheringWithBLOBs){

        gatheringService.add(tbGatheringWithBLOBs);
        Result result = new Result(true, StatusCode.OK, "保存成功");
        return result;
    }


    /**
     * update
     * @param tbGatheringWithBLOBs
     * @return
     */
    @PutMapping("/update-gathering")
    public Result updateGathering(@RequestBody TbGatheringWithBLOBs tbGatheringWithBLOBs){
        gatheringService.updateGathering(tbGatheringWithBLOBs);
        Result result = new Result(true, StatusCode.OK, "更新ok");
        return result;
    }


    /**
     * delete
     * @param id
     * @return
     */
    @DeleteMapping("/delete-gathering/{id}")
    public Result deleteGathering(@PathVariable("id") String id){
        gatheringService.delete(id);
        Result result = new Result(true, StatusCode.OK, "删除成功");
        return result;
    }
}
