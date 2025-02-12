package com.product.mapper;

import com.model.entity.product.ProductDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/12
 **/
@Mapper
public interface ProductDetailsMapper {
    ProductDetails getByProductId(Long productId);
}
