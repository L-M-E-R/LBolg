/**
 * @program: LBolg
 * @description:
 * @author: Lmer
 * @create: 2022-03-21 12:31
 **/
package com.lmer.controller;

import com.lmer.annotation.HttpLog;
import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.User;
import com.lmer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UseController {


    @Autowired
    public UserService userService;

    @GetMapping("/userInfo")
    public ResponseResult userInfo(){
        return userService.userInfo();
    }

    @PostMapping("/register")
    @HttpLog(businessName = "用户注册")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }

}
