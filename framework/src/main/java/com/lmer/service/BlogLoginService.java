package com.lmer.service;

import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.User;

public interface BlogLoginService {
    ResponseResult login(User user);
}