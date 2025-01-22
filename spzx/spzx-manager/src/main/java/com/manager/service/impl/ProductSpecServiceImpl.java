package com.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.mapper.ProductSpecMapper;
import com.manager.service.ProductSpecService;
import com.model.entity.product.ProductSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/21
 **/
@Service
public class ProductSpecServiceImpl implements ProductSpecService {
    @Autowired
    ProductSpecMapper productSpecMapper;

    @Override
    public PageInfo<ProductSpec> listByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductSpec> productSpecList = productSpecMapper.listByPage();
        PageInfo<ProductSpec> productSpecPageInfo =new PageInfo(productSpecList);
        return productSpecPageInfo;
    }

    @Override
    public void saveProductSpec(ProductSpec productSpec) {
        productSpecMapper.saveProductSpec(productSpec);
    }

    @Override
    public void updateProductSpec(ProductSpec productSpec) {
        productSpecMapper.updateProductSpec(productSpec);
    }

    @Override
    public void deleteProductSpec(Long id) {
        productSpecMapper.deleteProductSpec(id);
    }
}
