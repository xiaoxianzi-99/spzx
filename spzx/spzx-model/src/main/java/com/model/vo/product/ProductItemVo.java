package com.model.vo.product;

import com.alibaba.fastjson.JSONArray;
import com.model.entity.product.Product;
import com.model.entity.product.ProductSku;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/12
 **/
@Data
public class ProductItemVo {
    private ProductSku productSku;
    private Product product;
    private List<String> sliderUrlList;
    private List<String> detailsImageUrlList;
    private JSONArray specValueList;
    private Map<String,Object> skuSpecValueMap;
}
