package com.product.mapper;

import com.model.entity.product.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/7
 **/
@Mapper
public interface CategoryMapper {
    List<Category> findOneCategory();

    List<Category> findAll();
}
