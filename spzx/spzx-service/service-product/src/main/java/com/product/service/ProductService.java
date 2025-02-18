package com.product.service;

import com.github.pagehelper.PageInfo;
import com.model.dto.product.ProductSkuDto;
import com.model.dto.product.SkuSaleDto;
import com.model.entity.product.ProductSku;
import com.model.vo.product.ProductItemVo;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/7
 **/
public interface ProductService {
    /**
     * 按照销量来排序sku展示在首页
     * @return
     */
    List<ProductSku> findProductSkuBySale();

    PageInfo<ProductSku> findByPage(Integer page, Integer limit, ProductSkuDto productSkuDto);

    ProductItemVo item(Long skuId);

    ProductSku getBySkuId(Long skuId);

    Boolean updateSkuSaleNum(List<SkuSaleDto> skuSaleDtoList);
}
