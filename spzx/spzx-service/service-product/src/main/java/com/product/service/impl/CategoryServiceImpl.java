package com.product.service.impl;

import com.model.entity.product.Category;
import com.product.mapper.CategoryMapper;
import com.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/7
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> findOneCategory() {
        return categoryMapper.findOneCategory();
    }
}
