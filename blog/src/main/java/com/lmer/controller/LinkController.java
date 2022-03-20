/**
 * @program: LBolg
 * @description:
 * @author: Lmer
 * @create: 2022-03-20 17:02
 **/
package com.lmer.controller;

import com.lmer.domain.ResponseResult;
import com.lmer.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/getAllLink")
    public ResponseResult getAllLink(){
        return linkService.getAllLink();
    }
}
