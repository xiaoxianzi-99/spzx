package com.manager.controller;

import com.github.pagehelper.PageInfo;
import com.manager.service.CategoryBrandService;
import com.model.dto.product.CategoryBrandDto;
import com.model.entity.product.CategoryBrand;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/20
 **/
@RestController
@RequestMapping("/admin/product/categoryBrand")
public class CategoryBrandController {
    @Autowired
    private CategoryBrandService categoryBrandService;

    @GetMapping("/list/{pageNum}/{pageSize}")
    public Result<PageInfo<CategoryBrand>> listCategoryBrand(@PathVariable("pageNum") Integer pageNum,
                                                             @PathVariable("pageSize") Integer pageSize,
                                                             CategoryBrandDto categoryBrandDto) {
        PageInfo<CategoryBrand> categoryBrandPageInfo = categoryBrandService.listCategoryBrand(pageNum, pageSize, categoryBrandDto);
        return Result.build(categoryBrandPageInfo, ResultCodeEnum.SUCCESS);
    }
    @PostMapping("/save")
    public Result save(@RequestBody CategoryBrand categoryBrand) {
        categoryBrandService.save(categoryBrand);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    @PutMapping("/update")
    public Result update(@RequestBody CategoryBrand categoryBrand) {
        categoryBrandService.update(categoryBrand);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id) {
        categoryBrandService.delete(id);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
}
