/**
 * @program: LBolg
 * @description:  字面常量
 * @author: Lmer
 * @create: 2022-03-20 11:59
 **/
package com.lmer.constants;

public class SystemConstants {
    /**
     * 分页大小
     */
    public static final int PAGE_SIZE = 10;

    /**
     * 文章已发布
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    /**
     * 文章是草稿状态
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;

    /**
     * 分类是草稿
     */
    public static final String CATEGORY_STATUS_DRAFT = "1";

    /**
     * 分类已发布
     */
    public static final String CATEGORY_STATUS_NORMAL = "0";
    /**
     * 友链审核成功
     */
    public static final String LINK_STATUS_PASS = "0";
    /**
     * 友链审核失败
     */
    public static final String LINK_STATUS_REFUSED = "1";
    /**
     * 友链还在审核
     */
    public static final String LINK_STATUS_AUDITING = "2";
    /**
     * 评论为文章评论
     */
    public static final String COMMENT_TYPE_ARTICLE = "0";
    /**
     * 评论为友链评论
     */
    public static final String COMMENT_TYPE_LINK = "1";
    /**
     * 是根评论
     */
    public static final Long ROOT_COMMENT = -1L;


}
