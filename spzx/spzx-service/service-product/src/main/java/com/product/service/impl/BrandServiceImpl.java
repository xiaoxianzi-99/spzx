package com.product.service.impl;

import com.model.entity.product.Brand;
import com.product.mapper.BrandMapper;
import com.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/8
 **/
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;
    @Override
    @Cacheable(value = "brandList", unless="#result.size() == 0")
    public List<Brand> findAll() {
        return brandMapper.findAll();
    }
}
