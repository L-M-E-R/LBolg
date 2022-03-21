/**
 * @program: LBolg
 * @description:
 * @author: Lmer
 * @create: 2022-03-21 12:31
 **/
package com.lmer.controller;

import com.lmer.domain.ResponseResult;
import com.lmer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UseController {


    @Autowired
    public UserService userService;

    @GetMapping("/userInfo")
    public ResponseResult userInfo(){
        return userService.userInfo();
    }

}
