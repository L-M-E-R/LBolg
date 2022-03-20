package com.lmer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author Lmer
 * @since 2022-03-20 17:04:50
 */
public interface LinkService extends IService<Link> {


    /**
     * 获取所有友链
     * @return
     */
    ResponseResult getAllLink();
}
