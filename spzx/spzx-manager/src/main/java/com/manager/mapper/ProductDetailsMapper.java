package com.manager.mapper;

import com.model.entity.product.ProductDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/22
 **/
@Mapper
public interface ProductDetailsMapper {
    void save(ProductDetails productDetails);

    ProductDetails selectByProductId(Long id);

    void update(ProductDetails productDetails);

    void deleteByProductId(Long id);
}
