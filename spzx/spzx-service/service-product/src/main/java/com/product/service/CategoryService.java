package com.product.service;

import com.model.entity.product.Category;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/7
 **/
public interface CategoryService {
    /**
     * 返回一级分类
     * @return
     */
    List<Category> findOneCategory();

    List<Category> findCategoryTree();
}
