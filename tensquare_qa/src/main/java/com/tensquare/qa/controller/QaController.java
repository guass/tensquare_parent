package com.tensquare.qa.controller;

import com.github.pagehelper.PageInfo;
import com.tensquare.qa.pojo.TbProblem;
import com.tensquare.qa.service.ProblemService;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/qa")
public class QaController {

    private ProblemService problemService;

    @GetMapping("/get-new-problem-list/{lable}/{page}/{size}")
    public Result getNewProblemList(@PathVariable("lable")String label, @PathVariable("page") String page,
                                    @PathVariable("size")String size){

        PageInfo<TbProblem> newProblemList = problemService.getNewProblemList(label, Integer.parseInt(page),
                Integer.parseInt(size));

        Result result = new Result(true, StatusCode.OK,"查询成功",newProblemList);
        return result;
    }

    @GetMapping("/get-hot-problem-list/{lable}/{page}/{size}")
    public Result getHotProblemList(@PathVariable("lable")String label, @PathVariable("page") String page,
                                    @PathVariable("size")String size){

        PageInfo<TbProblem> hotProblemList = problemService.getHotProblemList(label, Integer.parseInt(page),
                Integer.parseInt(size));

        Result result = new Result(true, StatusCode.OK,"查询成功",hotProblemList);
        return result;
    }

    @GetMapping("/get-wait-problem-list/{lable}/{page}/{size}")
    public Result getWaitProblemList(@PathVariable("lable")String label, @PathVariable("page") String page,
                                    @PathVariable("size")String size){

        PageInfo<TbProblem> waitProblemList = problemService.getWaitProblemList(label, Integer.parseInt(page),
                Integer.parseInt(size));

        Result result = new Result(true, StatusCode.OK,"查询成功",waitProblemList);
        return result;
    }
}
