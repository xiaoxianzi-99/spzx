package com.product.controller;

import com.model.entity.product.Category;
import com.model.entity.product.ProductSku;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import com.model.vo.h5.IndexVo;
import com.product.service.CategoryService;
import com.product.service.ProductService;
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
@RequestMapping("/api/product/index")
public class IndexController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public Result<IndexVo> findData(){
        List<Category> categoryList = categoryService.findOneCategory();
        List<ProductSku> productSkuList = productService.findProductSkuBySale();
        IndexVo indexVo = new IndexVo() ;
        indexVo.setCategoryList(categoryList);
        indexVo.setProductSkuList(productSkuList);
        return Result.build(indexVo , ResultCodeEnum.SUCCESS);
    }
}
