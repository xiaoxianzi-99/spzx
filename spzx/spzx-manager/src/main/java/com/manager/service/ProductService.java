package com.manager.service;

import com.github.pagehelper.PageInfo;
import com.model.dto.product.ProductDto;
import com.model.entity.product.Product;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/22
 **/
public interface ProductService {
    PageInfo<Product> listByPage(Integer pageNum, Integer pageSize, ProductDto productDto);
}
