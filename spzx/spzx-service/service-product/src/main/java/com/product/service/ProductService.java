package com.product.service;

import com.model.entity.product.ProductSku;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/7
 **/
public interface ProductService {
    /**
     * 按照销量来排序sku展示在首页
     * @return
     */
    List<ProductSku> findProductSkuBySale();
}
