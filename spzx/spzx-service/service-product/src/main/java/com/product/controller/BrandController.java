package com.product.controller;

import com.model.entity.product.Brand;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import com.product.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/8
 **/
@RestController
@RequestMapping("/api/product/brand")
public class BrandController {
    @Override
    BrandService brandService;
    @GetMapping("findAll")
    public Result<List<Brand>> findAll() {
        List<Brand> list = brandService.findAll();
        return Result.build(list, ResultCodeEnum.SUCCESS);
    }
}
