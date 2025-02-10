package com.product.controller;

import com.model.entity.product.Category;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import com.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/7
 **/
@RestController
@RequestMapping("/api/product/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/findCategoryTree")
    public Result<List<Category>> findCategoryTree(){
        List<Category> list = categoryService.findCategoryTree();
        return Result.build(list,  ResultCodeEnum.SUCCESS);
    }
}
