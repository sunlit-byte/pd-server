package com.sunlit.partpart.controller;

import com.sunlit.partpart.base.BaseResp;
import com.sunlit.partpart.bean.UserReq;
import com.sunlit.partpart.domain.UserEntity;
import com.sunlit.partpart.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-03 23:40
 **/
@RequestMapping("/user")
@RestController
@AllArgsConstructor
public class UserController {


    private final UserService userService;


    @RequestMapping("/register")
    public BaseResp register(@RequestBody UserReq req){
        return userService.register(req);
    }

    @RequestMapping("/edit")
    public BaseResp edit(@RequestBody UserReq req){
        userService.edit(req);
        return BaseResp.ok();
    }

    @RequestMapping("/login")
    public BaseResp login(@RequestBody UserReq req){
        String userId = userService.login(req);
        if(userId == null){
            return BaseResp.fail("用户名或密码错误");
        }else {
            return BaseResp.ok(userId);
        }
    }
    @RequestMapping("/info")
    public BaseResp info(@RequestBody UserReq req){
        UserEntity user = userService.info(req);
        return BaseResp.ok(user);
    }
}
