package com.lmer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmer.constants.SystemConstants;
import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.Article;
import com.lmer.domain.entity.Category;
import com.lmer.domain.vo.CategoryVo;
import com.lmer.mapper.CategoryMapper;
import com.lmer.service.ArticleService;
import com.lmer.service.CategoryService;
import com.lmer.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author Lmer
 * @since 2022-03-20 13:11:47
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    public ArticleService articleService;


    /**
     * 查询分类列表
     * @return 分类列表
     */
    @Override
    public ResponseResult getCategoryList() {
        //查询已发布的文章
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);

        List<Article> list = articleService.list(articleWrapper);
        //根据文章的分类id, 并且去重
        Set<Long> collect = list.stream()
                .map(Article::getCategoryId)
                .collect(Collectors.toSet());

        //根据分类id查询名字
        List<Category> categories = listByIds(collect);

        categories = categories.stream()
                .filter(category -> category.getStatus().equals(SystemConstants.CATEGORY_STATUS_NORMAL))
                .collect(Collectors.toList());

        //封装vo
        List<CategoryVo> categoryVos = BeanCopyUtils.copyList(categories, CategoryVo.class);

        return ResponseResult.okResult(categoryVos);
    }


}

