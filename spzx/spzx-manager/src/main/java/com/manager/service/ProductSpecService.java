package com.manager.service;

import com.github.pagehelper.PageInfo;
import com.model.entity.product.ProductSpec;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/21
 **/
public interface ProductSpecService {
    PageInfo<ProductSpec> listByPage(Integer pageNum, Integer pageSize);

    void saveProductSpec(ProductSpec productSpec);

    void updateProductSpec(ProductSpec productSpec);

    void deleteProductSpec(Long id);

    List<ProductSpec> findAll();
}
