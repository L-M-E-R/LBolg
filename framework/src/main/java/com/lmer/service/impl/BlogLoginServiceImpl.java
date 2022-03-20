/**
 * @program: LBolg
 * @description:
 * @author: Lmer
 * @create: 2022-03-20 17:39
 **/
package com.lmer.service.impl;

import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.LoginUser;
import com.lmer.domain.entity.User;
import com.lmer.domain.vo.BlogUserLoginVo;
import com.lmer.domain.vo.UserInfoVo;
import com.lmer.service.BlogLoginService;
import com.lmer.utils.BeanCopyUtils;
import com.lmer.utils.JwtUtil;
import com.lmer.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class BlogLoginServiceImpl implements BlogLoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        //判断是否认证通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("密码错误");
        }

        //获取userid 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();

        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);

        //把用户信息存入redis
        redisCache.setCacheObject("bloglogin:" + userId, loginUser, 24, TimeUnit.HOURS);

        //把token和userinfo封装 返回
        //把User转换成UserInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copy(loginUser.getUser(), UserInfoVo.class);

        BlogUserLoginVo vo = new BlogUserLoginVo(jwt,userInfoVo);

        return ResponseResult.okResult(vo);
    }


}
