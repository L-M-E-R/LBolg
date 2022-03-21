/**
 * @program: LBolg
 * @description:
 * @author: Lmer
 * @create: 2022-03-19 19:25
 **/
package com.lmer.controller;

import com.lmer.annotation.HttpLog;
import com.lmer.domain.ResponseResult;
import com.lmer.enums.AppHttpCodeEnum;
import com.lmer.service.ArticleService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList(){
        return articleService.hotArticleList();
    }

    @GetMapping("/articleList")
    @HttpLog(businessName = "获取文章列表")
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId){
        if(Objects.isNull(pageNum) || Objects.isNull(pageSize)){
            return ResponseResult.errorResult(AppHttpCodeEnum.BAD_REQUEST);
        }
        return articleService.articleList(pageNum, pageSize, categoryId);
    }

    @GetMapping("/{id}")
    public ResponseResult getArticle(@PathVariable("id") Long id){
        return articleService.getArticle(id);
    }

}
