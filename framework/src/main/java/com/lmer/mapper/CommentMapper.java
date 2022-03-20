package com.lmer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lmer.domain.entity.Comment;
import org.apache.ibatis.annotations.Mapper;


/**
 * 评论表(Comment)表数据库访问层
 *
 * @author Lmer
 * @since 2022-03-20 20:58:38
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}

