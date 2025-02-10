package com.product.mapper;

import com.model.entity.product.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/10
 **/
@Mapper
public interface BrandMapper {
    List<Brand> findAll();
}
