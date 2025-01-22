package com.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.mapper.CategoryBrandMapper;
import com.manager.service.CategoryBrandService;
import com.model.dto.product.CategoryBrandDto;
import com.model.entity.product.CategoryBrand;
import com.model.vo.common.ResultCodeEnum;
import com.service.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/20
 **/
@Service
public class CategoryBrandServiceImpl implements CategoryBrandService {
    @Autowired
    private CategoryBrandMapper categoryBrandMapper;
    @Override
    public PageInfo<CategoryBrand> listCategoryBrand(Integer pageNum, Integer pageSize, CategoryBrandDto categoryBrandDto) {
        PageHelper.startPage(pageNum,pageSize);
        List<CategoryBrand> categoryBrands = categoryBrandMapper.listCategoryBrand(categoryBrandDto);
        PageInfo<CategoryBrand> pageInfo = new PageInfo(categoryBrands);
        return pageInfo;
    }

    @Override
    public void save(CategoryBrand categoryBrand) {
        CategoryBrandDto categoryBrandDto = new CategoryBrandDto();
        categoryBrandDto.setBrandId(categoryBrand.getBrandId());
        categoryBrandDto.setCategoryId(categoryBrand.getCategoryId());
        List<CategoryBrand> categoryBrands = categoryBrandMapper.listCategoryBrand(categoryBrandDto);
        if(!categoryBrands.isEmpty()) {
            throw new BusinessException(ResultCodeEnum.CATEGOREBRAND_IS_EXISTS);
        }
        categoryBrandMapper.save(categoryBrand);
    }

    @Override
    public void update(CategoryBrand categoryBrand) {
        categoryBrandMapper.update(categoryBrand);
    }

    @Override
    public void delete(Long id) {
        categoryBrandMapper.delete(id);
    }
}
