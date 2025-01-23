package com.manager.service.impl;

import com.manager.mapper.ProductUnitMapper;
import com.manager.service.ProductUnitService;
import com.model.entity.product.ProductUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/23
 **/
@Service
public class ProductUnitServiceImpl implements ProductUnitService {
    @Autowired
    ProductUnitMapper productUnitMapper;
    @Override
    public List<ProductUnit> findAll() {
        List<ProductUnit> productUnitList=productUnitMapper.findAll();
        return productUnitList;
    }
}
