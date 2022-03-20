package com.lmer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lmer.domain.entity.Link;
import org.apache.ibatis.annotations.Mapper;


/**
 * 友链(Link)表数据库访问层
 *
 * @author Lmer
 * @since 2022-03-20 17:04:50
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {

}

