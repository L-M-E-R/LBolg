/**
 * @program: LBolg
 * @description:
 * @author: Lmer
 * @create: 2022-03-20 16:20
 **/
package com.lmer.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ArticleVo {
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 文章摘要
     */
    private String summary;
    /**
     * 缩略图
     */
    private String thumbnail;
    /**
     * 访问量
     */
    private Long viewCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 所属分类名字
     */
    private String categoryName;
    /**
     * 所属分类id
     */
    private Long categoryId;
}
