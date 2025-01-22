package com.manager.controller;

import com.github.pagehelper.PageInfo;
import com.manager.service.ProductService;
import com.model.dto.product.ProductDto;
import com.model.entity.product.Product;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/22
 **/
@RestController
@RequestMapping("/admin/product/product")
public class productController {
    @Autowired
    private ProductService productService;
    @GetMapping("/listByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<Product>> listByPage(@PathVariable("pageNum") Integer pageNum,
                                                @PathVariable("pageSize") Integer pageSize,
                                                ProductDto productDto){
        PageInfo<Product> productPageInfo =productService.listByPage(pageNum,pageSize,productDto);
        return Result.build(productPageInfo, ResultCodeEnum.SUCCESS);
    }
}
