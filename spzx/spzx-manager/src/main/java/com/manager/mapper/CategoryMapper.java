package com.manager.mapper;

import com.model.entity.product.Category;
import com.model.vo.product.CategoryExcelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/17
 **/
@Mapper
public interface CategoryMapper {
    Long countByParentId(Long id);

    List<Category> findCategoryByParentId(Long parentId);

    List<Category> selectCategory();

    void batchInsert(List<CategoryExcelVo> cachedDataList);
}
