/**
 * @program: LBolg
 * @description:
 * @author: Lmer
 * @create: 2022-03-20 21:00
 **/
package com.lmer.controller;

import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.Comment;
import com.lmer.domain.entity.LoginUser;
import com.lmer.enums.AppHttpCodeEnum;
import com.lmer.exception.SystemException;
import com.lmer.service.CommentService;
import com.lmer.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping("/commentList")
    public ResponseResult getCommentList(Long articleId, Integer pageNum, Integer pageSize){
        return commentService.getCommentList(articleId, pageNum, pageSize);
    }


    @PostMapping
    public ResponseResult addComment(@RequestBody Comment comment){
        if(!StringUtils.hasText(comment.getContent())){
            throw new SystemException(AppHttpCodeEnum.BAD_REQUEST);
        }
        return commentService.addComment(comment);
    }


}
