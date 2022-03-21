package com.lmer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.User;
import com.lmer.domain.vo.UserInfoVo;
import com.lmer.enums.AppHttpCodeEnum;
import com.lmer.exception.SystemException;
import com.lmer.mapper.UserMapper;
import com.lmer.service.UserService;
import com.lmer.utils.BeanCopyUtils;
import com.lmer.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * 用户表(User)表服务实现类
 *
 * @author Lmer
 * @since 2022-03-20 21:35:51
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    public PasswordEncoder passwordEncoder;


    @Override
    public ResponseResult userInfo() {

        Long userId = SecurityUtils.getUserId();

        User user = getById(userId);

        UserInfoVo userInfoVo = BeanCopyUtils.copy(user, UserInfoVo.class);

        return ResponseResult.okResult(userInfoVo);
    }

    @Override
    public ResponseResult register(User user) {
        // 数据的非空判断
        if(!StringUtils.hasText(user.getUserName()) ||
                StringUtils.hasText(user.getEmail()) ||
                StringUtils.hasText(user.getNickName()) ||
                StringUtils.hasText(user.getPassword())
        ){
            throw new SystemException(AppHttpCodeEnum.BAD_REQUEST);
        }
        // 对数据进行查重
        exits(user);

        // 密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 存入数据库
        save(user);

        return ResponseResult.okResult();
    }

    private void exits(User user){
        if(count(new LambdaQueryWrapper<User>().eq(User::getUserName, user.getUserName())) > 0){
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if(count(new LambdaQueryWrapper<User>().eq(User::getEmail, user.getEmail())) > 0){
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }
        if(count(new LambdaQueryWrapper<User>().eq(User::getNickName, user.getNickName())) > 0){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
        }
    }
}

