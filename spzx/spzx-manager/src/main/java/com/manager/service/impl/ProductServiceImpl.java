package com.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.mapper.ProductDetailsMapper;
import com.manager.mapper.ProductMapper;
import com.manager.mapper.ProductSkuMapper;
import com.manager.service.ProductService;
import com.model.dto.product.ProductDto;
import com.model.entity.product.Product;
import com.model.entity.product.ProductDetails;
import com.model.entity.product.ProductSku;
import com.model.vo.common.ResultCodeEnum;
import com.service.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/22
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductDetailsMapper productDetailsMapper;
    @Autowired
    ProductSkuMapper productSkuMapper;

    @Override
    public PageInfo<Product> listByPage(Integer pageNum, Integer pageSize, ProductDto productDto) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> productList = productMapper.listByPage(productDto);
        PageInfo<Product> productPageInfo =new PageInfo(productList);
        return productPageInfo;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveProduct(Product product) {
        // 保存商品数据
        product.setStatus(0);              // 设置上架状态为0
        product.setAuditStatus(0);         // 设置审核状态为0
        productMapper.save(product);

        // 保存商品sku数据
        List<ProductSku> productSkuList = product.getProductSkuList();
        int index =0;
        for (ProductSku productSku : productSkuList) {
            productSku.setSkuCode(product.getId() + "_" + index);       // 构建skuCode

            productSku.setProductId(product.getId());               // 设置商品id
            productSku.setSkuName(product.getName() + productSku.getSkuSpec());
            productSku.setSaleNum(0);                               // 设置销量
            productSku.setStatus(0);
            productSkuMapper.save(productSku);                    // 保存数据
        }
        // 保存商品详情数据
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductId(product.getId());
        productDetails.setImageUrls(product.getDetailsImageUrls());
        productDetailsMapper.save(productDetails);
    }

    @Override
    public Product getById(Long id) {
        // 根据id查询商品数据
        Product product = productMapper.selectById(id);

        // 根据商品的id查询sku数据
        List<ProductSku> productSkuList = productSkuMapper.selectByProductId(id);
        product.setProductSkuList(productSkuList);

        // 根据商品的id查询商品详情数据
        ProductDetails productDetails = productDetailsMapper.selectByProductId(product.getId());
        product.setDetailsImageUrls(productDetails.getImageUrls());

        // 返回数据
        return product;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateProduct(Product product) {
        // 更新商品数据
        productMapper.update(product);

        // 更新商品sku数据
        List<ProductSku> productSkuList = product.getProductSkuList();
        for (ProductSku productSku : productSkuList) {
            productSkuMapper.update(productSku);
        }

        // 更新商品详情数据
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductId(product.getId());
        productDetails.setImageUrls(product.getDetailsImageUrls());
        productDetailsMapper.update(productDetails);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteProduct(Long id) {
        // 删除商品数据
        productMapper.delete(id);

        // 删除商品sku数据
        productSkuMapper.deleteByProductId(id);

        // 根据商品的id删除商品的详情数据
        productDetailsMapper.deleteByProductId(id);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateAuditStatus(Long id, Integer auditStatus) {
        Product product = productMapper.selectById(id);
        if(product == null){
            throw new BusinessException(ResultCodeEnum.PRODUCT_IS_NOT_EXISTS);
        }
        if(auditStatus == 1){
            product.setAuditStatus(1);
            product.setAuditMessage("审核通过");
        }else {
            product.setAuditStatus(-1);
            product.setAuditMessage("审核不通过");
        }
        productMapper.update(product);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateStatus(Long id, Integer status) {
        Product product = productMapper.selectById(id);
        if(product == null){
            throw new BusinessException(ResultCodeEnum.PRODUCT_IS_NOT_EXISTS);
        }
        if(status == 1){
            product.setStatus(1);
        }else {
            product.setStatus(-1);
        }
        productMapper.update(product);
        List<ProductSku> productSkuList = productSkuMapper.selectByProductId(id);
        for (ProductSku productSku : productSkuList) {
            productSku.setStatus(status);
            productSkuMapper.update(productSku);
        }
    }
}
