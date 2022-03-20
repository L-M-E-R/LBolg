/**
 * @program: LBolg
 * @description:
 * @author: Lmer
 * @create: 2022-03-20 13:24
 **/
package com.lmer.controller;

import com.lmer.domain.ResponseResult;
import com.lmer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping("/getCategoryList")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }

}
