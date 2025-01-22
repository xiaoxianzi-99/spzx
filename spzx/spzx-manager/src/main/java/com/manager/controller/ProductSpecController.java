package com.manager.controller;

import com.github.pagehelper.PageInfo;
import com.manager.service.ProductSpecService;
import com.model.entity.product.ProductSpec;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/21
 **/
@RestController
@RequestMapping("/admin/product/productSpec")
public class ProductSpecController {
    @Autowired
    ProductSpecService productSpecService;
    @GetMapping("/listByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<ProductSpec>> listByPage(@PathVariable("pageNum") Integer pageNum,
                                                    @PathVariable("pageSize") Integer pageSize){
        PageInfo<ProductSpec> productSpecPageInfo = productSpecService.listByPage(pageNum,pageSize);
        return Result.build(productSpecPageInfo, ResultCodeEnum.SUCCESS);
    }
    @PostMapping("/save")
    public Result saveProductSpec(@RequestBody ProductSpec productSpec) {
        productSpecService.saveProductSpec(productSpec);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    @PutMapping("/updateById")
    public Result updateProductSpec( @RequestBody ProductSpec productSpec) {
        productSpecService.updateProductSpec(productSpec);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    @DeleteMapping("/deleteById/{id}")
    public Result deleteProductSpec(@PathVariable("id") Long id) {
        productSpecService.deleteProductSpec(id);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
}
