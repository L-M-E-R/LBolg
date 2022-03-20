package com.lmer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lmer.domain.entity.Category;
import org.apache.ibatis.annotations.Mapper;


/**
 * 分类表(Category)表数据库访问层
 *
 * @author lmer
 * @since 2022-03-20 13:11:47
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}

