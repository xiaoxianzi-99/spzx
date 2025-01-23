package com.manager.mapper;

import com.model.dto.product.ProductDto;
import com.model.entity.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/22
 **/
@Mapper
public interface ProductMapper {
    List<Product> listByPage(ProductDto productDto);

    void save(Product product);

    Product selectById(Long id);

    void update(Product product);

    void delete(Long id);
}
