/**
 * @program: LBolg
 * @description:
 * @author: Lmer
 * @create: 2022-03-19 19:20
 **/
package com.lmer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lmer.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
