package com.lmer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmer.domain.entity.User;
import com.lmer.mapper.UserMapper;
import com.lmer.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author Lmer
 * @since 2022-03-20 21:35:51
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

