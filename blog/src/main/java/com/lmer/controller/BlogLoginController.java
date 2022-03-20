package com.lmer.controller;

import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.LoginUser;
import com.lmer.domain.entity.User;
import com.lmer.enums.AppHttpCodeEnum;
import com.lmer.exception.SystemException;
import com.lmer.service.BlogLoginService;
import com.lmer.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogLoginController {
    @Autowired
    private BlogLoginService blogLoginService;

    @Autowired
    private RedisCache redisCache;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult logout(@RequestHeader("token") String token){
        // 从SecurityContextHolder中拿到在jwtFilter中已经装入的授权对象
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        Long userId = loginUser.getUser().getId();

        redisCache.deleteObject("bloglogin:" + userId);

        return ResponseResult.okResult();
    }
}