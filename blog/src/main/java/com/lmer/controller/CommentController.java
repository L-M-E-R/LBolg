/**
 * @program: LBolg
 * @description:
 * @author: Lmer
 * @create: 2022-03-20 21:00
 **/
package com.lmer.controller;

import com.lmer.domain.ResponseResult;
import com.lmer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping("/commentList")
    public ResponseResult getCommentList(Long articleId, Integer pageNum, Integer pageSize){
        return commentService.getCommentList(articleId, pageNum, pageSize);
    }



}
