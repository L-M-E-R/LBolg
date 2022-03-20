/**
 * @program: LBolg
 * @description: 热门文章VO
 * @author: Lmer
 * @create: 2022-03-20 11:44
 **/
package com.lmer.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotArticleVo {
    private Long id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章浏览量
     */
    private Long viewCount;
}
