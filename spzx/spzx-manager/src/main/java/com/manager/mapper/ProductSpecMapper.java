package com.manager.mapper;

import com.model.entity.product.ProductSpec;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/21
 **/
@Mapper
public interface ProductSpecMapper {
    List<ProductSpec> listByPage();

    void saveProductSpec(ProductSpec productSpec);

    void updateProductSpec(ProductSpec productSpec);

    void deleteProductSpec(Long id);

    List<ProductSpec> findAll();
}
