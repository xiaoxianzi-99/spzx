package com.manager.controller;

import com.github.pagehelper.PageInfo;
import com.manager.service.ProductService;
import com.model.dto.product.ProductDto;
import com.model.entity.product.Product;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/22
 **/
@RestController
@RequestMapping("/admin/product/product")
public class productController {
    @Autowired
    private ProductService productService;
    @GetMapping("/updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable("id") Long id, @PathVariable("status") Integer status){
        productService.updateStatus(id,status);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    /**
     * 更新审核状态
     * @param id
     * @param auditStatus
     * @return
     */
    @GetMapping("/updateAuditStatus/{id}/{auditStatus}")
    public Result updateAuditStatus(@PathVariable("id") Long id, @PathVariable("auditStatus") Integer auditStatus) {
        productService.updateAuditStatus(id, auditStatus);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }
    /**
     * 删除商品
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    /**
     * 更新商品
     * @param product
     * @return
     */
    @PutMapping("/update")
    public Result updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }

    /**
     * 根据id查询商品 用于回显
     * @param id
     * @return
     */
    @GetMapping("/getById/{id}")
    public Result<Product> getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        return Result.build(product , ResultCodeEnum.SUCCESS) ;
    }
    @PostMapping("/save")
    public Result saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    @GetMapping("/listByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<Product>> listByPage(@PathVariable("pageNum") Integer pageNum,
                                                @PathVariable("pageSize") Integer pageSize,
                                                ProductDto productDto){
        PageInfo<Product> productPageInfo =productService.listByPage(pageNum,pageSize,productDto);
        return Result.build(productPageInfo, ResultCodeEnum.SUCCESS);
    }
}
