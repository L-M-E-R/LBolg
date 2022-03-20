package com.lmer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmer.constants.SystemConstants;
import com.lmer.domain.ResponseResult;
import com.lmer.domain.entity.Link;
import com.lmer.domain.vo.LinkVo;
import com.lmer.mapper.LinkMapper;
import com.lmer.service.LinkService;
import com.lmer.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author Lmer
 * @since 2022-03-20 17:04:50
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {
        // 只查询审核通过的
        LambdaQueryWrapper<Link> queryWrapper= new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_PASS);

        List<Link> links = list(queryWrapper);

        //封装vo
        List<LinkVo> linkVos = BeanCopyUtils.copyList(links, LinkVo.class);

        return ResponseResult.okResult(linkVos);
    }
}

