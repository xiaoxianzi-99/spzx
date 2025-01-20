package com.manager.service;

import com.github.pagehelper.PageInfo;
import com.model.entity.product.Brand;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/18
 **/
public interface BrandService {
    PageInfo<Brand> list(Integer pageNum, Integer pageSize);

    void save(Brand brand);

    void update(Brand brand);

    void deleteById(Long id);

    List<Brand> findAll();
}
