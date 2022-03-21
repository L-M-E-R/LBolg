package com.lmer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.User;
import com.lmer.domain.vo.UserInfoVo;
import com.lmer.mapper.UserMapper;
import com.lmer.service.UserService;
import com.lmer.utils.BeanCopyUtils;
import com.lmer.utils.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author Lmer
 * @since 2022-03-20 21:35:51
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public ResponseResult userInfo() {

        Long userId = SecurityUtils.getUserId();

        User user = getById(userId);

        UserInfoVo userInfoVo = BeanCopyUtils.copy(user, UserInfoVo.class);

        return ResponseResult.okResult(userInfoVo);
    }
}

