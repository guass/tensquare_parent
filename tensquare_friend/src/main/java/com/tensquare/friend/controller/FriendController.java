package com.tensquare.friend.controller;

import com.tensquare.friend.feign.UserClient;
import com.tensquare.friend.service.FriendService;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: guass
 * @description: FriendController
 * @data: 2019-05-28 12:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/friend")
public class FriendController {

    @Resource
    private FriendService friendService;


    @PostMapping("/add/friend/{userId}/{friendId}")
    public Result addFriend(@PathVariable("userId") String userId, @PathVariable("friendId") String friendId){
        friendService.addFriend(userId,friendId);
        Result result = new Result(true, StatusCode.OK, "add ok");
        return result;
    }


    @PostMapping("/add/no/friend/{userId}/{friendId}")
    public Result addNoFriend(@PathVariable("userId") String userId, @PathVariable("friendId") String friendId){
        friendService.addNoFriend(userId,friendId);
        Result result = new Result(true, StatusCode.OK, "add ok");
        return result;
    }

}
