package com.lmer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author Lmer
 * @since 2022-03-20 20:58:38
 */
public interface CommentService extends IService<Comment> {

    ResponseResult getCommentList(Long articleId, Integer pageNum, Integer pageSize);
}
