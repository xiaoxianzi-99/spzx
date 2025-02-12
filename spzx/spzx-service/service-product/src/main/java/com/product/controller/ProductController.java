package com.product.controller;

import com.github.pagehelper.PageInfo;
import com.model.dto.product.ProductSkuDto;
import com.model.entity.product.ProductSku;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import com.model.vo.product.ProductItemVo;
import com.product.service.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/10
 **/
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping(value = "/{page}/{limit}")
    public Result<PageInfo<ProductSku>> findByPage(@Parameter(name = "page", description = "当前页码", required = true) @PathVariable Integer page,
                                                   @Parameter(name = "limit", description = "每页记录数", required = true) @PathVariable Integer limit,
                                                   @Parameter(name = "productSkuDto", description = "搜索条件对象", required = false) ProductSkuDto productSkuDto) {
        PageInfo<ProductSku> pageInfo = productService.findByPage(page, limit, productSkuDto);
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 获取商品详情
     * @param skuId
     * @return
     */
    @GetMapping("/item/{skuId}")
    public Result<ProductItemVo> item(@Parameter(name = "skuId", description = "商品skuId", required = true) @PathVariable Long skuId) {
        ProductItemVo productItemVo = productService.item(skuId);
        return Result.build(productItemVo , ResultCodeEnum.SUCCESS);
    }
}
