package com.manager.service;

import com.github.pagehelper.PageInfo;
import com.model.dto.product.CategoryBrandDto;
import com.model.entity.product.CategoryBrand;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/20
 **/
public interface CategoryBrandService {

    PageInfo<CategoryBrand> listCategoryBrand(Integer pageNum, Integer pageSize, CategoryBrandDto categoryBrandDto);

    void save(CategoryBrand categoryBrand);

    void update(CategoryBrand categoryBrand);

    void delete(Long id);

    List<CategoryBrand> findBrandByCategoryId(Integer categoryId);
}
