package com.manager.controller;

import com.github.pagehelper.PageInfo;
import com.manager.service.BrandService;
import com.model.entity.product.Brand;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/18
 **/
@RestController
@RequestMapping("/admin/product/brand")
public class BrandController {
    @Autowired
    BrandService brandService;
    @GetMapping("/list/{pageNum}/{pageSize}")
    public Result<PageInfo<Brand>> list(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageInfo<Brand> pageInfo = brandService.list(pageNum, pageSize);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }
    @PostMapping("/save")
    public Result save(@RequestBody Brand brand) {
        brandService.save(brand);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Brand brand) {
        brandService.update(brand);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable("id") Long id) {
        brandService.deleteById(id);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    @GetMapping("/findAll")
    public Result<List<Brand>> findAll() {
        List<Brand> brandList = brandService.findAll();
        return Result.build(brandList, ResultCodeEnum.SUCCESS);
    }
}
