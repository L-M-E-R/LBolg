/**
 * @program: LBolg
 * @description: 文章Service
 * @author: Lmer
 * @create: 2022-03-19 19:21
 **/
package com.lmer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lmer.domain.entity.Article;
import com.lmer.domain.ResponseResult;

public interface ArticleService extends IService<Article> {
    /**
     * 查询热门文章
     * @return
     */
    ResponseResult hotArticleList();


    /**
     * 查询文章列表
     * @param pageNum 页码
     * @param pageSize 分页大小
     * @param categoryId 分类id
     * @return
     */
    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    /**
     * 文章详情
     * @param id
     * @return
     */
    ResponseResult getArticle(Long id);
}
