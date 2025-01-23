package com.manager.mapper;

import com.model.entity.product.ProductUnit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/23
 **/
@Mapper
public interface ProductUnitMapper {
    List<ProductUnit> findAll();
}
