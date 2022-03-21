/**
 * @program: LBolg
 * @description:
 * @author: Lmer
 * @create: 2022-03-19 19:22
 **/
package com.lmer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmer.constants.SystemConstants;
import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.Article;
import com.lmer.domain.vo.ArticleListVo;
import com.lmer.domain.vo.ArticleVo;
import com.lmer.domain.vo.HotArticleVo;
import com.lmer.domain.vo.PageVo;
import com.lmer.enums.AppHttpCodeEnum;
import com.lmer.mapper.ArticleMapper;
import com.lmer.service.ArticleService;
import com.lmer.service.CategoryService;
import com.lmer.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    public CategoryService categoryService;

    @Override
    public ResponseResult hotArticleList() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL)
                .orderByAsc(Article::getViewCount);

        Page<Article> page = new Page<>(1,10);
        page(page, queryWrapper);

        List<Article> list = page.getRecords();
        List<HotArticleVo> voList = BeanCopyUtils.copyList(list, HotArticleVo.class);

        return ResponseResult.okResult(voList);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper // 如果有id就是查询一个分类下的数据, 如果为空就是首页查询所有文章
                .eq(Objects.nonNull(categoryId) && categoryId > 0, Article::getId, categoryId)
                // 已发布
                .eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL)
                // 置顶在最前
                .orderByDesc(Article::getIsTop);

        // 分页
        Page<Article> page = new Page<>(pageNum, pageSize);
        page(page, queryWrapper);

        //查询分类名字
        List<Article> articles = page.getRecords().stream()
                .map(article -> article.setCategoryName(categoryService.getById(article.getCategoryId()).getName()))
                .collect(Collectors.toList());

        // 封装查询结果
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyList(articles, ArticleListVo.class);
        PageVo pageVo = new PageVo(articleListVos, page.getTotal());

        return ResponseResult.okResult(pageVo);
    }


    @Override
    public ResponseResult getArticle(Long id) {
        // 根据id查询
        Article article = getById(id);
        if(Objects.isNull(article)){
            return ResponseResult.errorResult(AppHttpCodeEnum.BAD_REQUEST);
        }

        // 封装vo
        ArticleVo articleVo = BeanCopyUtils.copy(article, ArticleVo.class);

        // 查询分类名字
        Long categoryId = articleVo.getCategoryId();
        if(Objects.nonNull(categoryId)){
            articleVo.setCategoryName(categoryService.getById(categoryId).getName());
        }


        // 封装查询结果

        return ResponseResult.okResult(articleVo);
    }
}
