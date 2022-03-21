package com.lmer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmer.constants.SystemConstants;
import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.Comment;
import com.lmer.domain.vo.CommentVo;
import com.lmer.domain.vo.PageVo;
import com.lmer.mapper.CommentMapper;
import com.lmer.service.CommentService;
import com.lmer.service.UserService;
import com.lmer.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author Lmer
 * @since 2022-03-20 20:58:38
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private UserService userService;

    @Override
    public ResponseResult getCommentList(Long articleId, Integer pageNum, Integer pageSize) {
        // 查根评论
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<Comment>();

        queryWrapper
                // 是文章评论
                .eq(Objects.nonNull(articleId), Comment::getArticleId, articleId)
                .eq(Objects.nonNull(articleId), Comment::getType, SystemConstants.COMMENT_TYPE_ARTICLE)
                // 是友链评论
                .eq(Objects.isNull(articleId), Comment::getType, SystemConstants.COMMENT_TYPE_LINK)
                // 是根评论
                .eq(Comment::getRootId, SystemConstants.ROOT_COMMENT);

        // 分页查询
        Page<Comment> page = new Page<>(pageNum, pageSize);
        page(page, queryWrapper);

        //封装
        List<CommentVo> commentVos = getCommentVos(page.getRecords());
        commentVos = setChildComments(commentVos);

        return ResponseResult.okResult(new PageVo(commentVos, page.getTotal()));
    }

    @Override
    public ResponseResult addComment(Comment comment) {
        save(comment);
        return ResponseResult.okResult();
    }

    private List<CommentVo> getCommentVos(List<Comment> list){
        List<CommentVo> commentVos = BeanCopyUtils.copyList(list, CommentVo.class);

        return commentVos.stream()
                .peek(comment -> {
                    // 查询评论人名字
                    comment.setUsername(userService.getById(comment.getCreateBy()).getNickName());
                    // 查询被评论人名字
                    if(comment.getRootId() != -1){
                        // 如果是根评论就不用查
                        comment.setToCommentUserName(userService.getById(comment.getToCommentUserId()).getNickName());
                    }
                })
                .collect(Collectors.toList());
    }

    private List<CommentVo> setChildComments(List<CommentVo> list){
        return list.stream()
                .peek(comment -> {
                    // 根据id查询子评论
                    LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.eq(Comment::getRootId, comment.getId());

                    List<Comment> children = list(queryWrapper);

                    // 封装
                    List<CommentVo> childrenVos = getCommentVos(children);

                    comment.setChildren(childrenVos);
                })
                .collect(Collectors.toList());

    }
}

