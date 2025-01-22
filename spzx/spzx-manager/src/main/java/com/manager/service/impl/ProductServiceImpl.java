package com.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.mapper.ProductMapper;
import com.manager.service.ProductService;
import com.model.dto.product.ProductDto;
import com.model.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/22
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public PageInfo<Product> listByPage(Integer pageNum, Integer pageSize, ProductDto productDto) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> productList = productMapper.listByPage(productDto);
        PageInfo<Product> productPageInfo =new PageInfo(productList);
        return productPageInfo;
    }
}
