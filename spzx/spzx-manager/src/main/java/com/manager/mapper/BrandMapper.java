package com.manager.mapper;

import com.model.entity.product.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/18
 **/
@Mapper
public interface BrandMapper {
    List<Brand> list();

    void save(Brand brand);

    void update(Brand brand);

    void deleteById(Long id);

    List<Brand> findAll();
}
