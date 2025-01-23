package com.manager.mapper;

import com.model.dto.product.CategoryBrandDto;
import com.model.entity.product.CategoryBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/20
 **/
@Mapper
public interface CategoryBrandMapper {
    List<CategoryBrand> listCategoryBrand(CategoryBrandDto categoryBrandDto);

    void save(CategoryBrand categoryBrand);

    void update(CategoryBrand categoryBrand);

    void delete(Long id);

    List<CategoryBrand> findBrandByCategoryId(Integer categoryId);
}
