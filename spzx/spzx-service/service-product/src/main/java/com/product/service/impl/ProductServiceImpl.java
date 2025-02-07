package com.product.service.impl;

import com.model.entity.product.ProductSku;
import com.product.mapper.ProductSkuMapper;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/7
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductSkuMapper productMapper;
    @Override
    public List<ProductSku> findProductSkuBySale() {
        return productMapper.findProductSkuBySale();
    }
}
