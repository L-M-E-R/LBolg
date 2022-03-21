package com.lmer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.User;


/**
 * 用户表(User)表服务接口
 *
 * @author Lmer
 * @since 2022-03-20 21:35:51
 */
public interface UserService extends IService<User> {

    ResponseResult userInfo();

    ResponseResult register(User user);
}
