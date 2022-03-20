package com.lmer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author Lmer
 * @since 2022-03-20 13:10:58
 */
public interface CategoryService extends IService<Category> {

    /**
     * 查询分类列表
     * @return 分类列表
     */
    ResponseResult getCategoryList();
}
