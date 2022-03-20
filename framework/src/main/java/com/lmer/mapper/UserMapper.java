package com.lmer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lmer.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户表(User)表数据库访问层
 *
 * @author Lmer
 * @since 2022-03-20 17:28:24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

