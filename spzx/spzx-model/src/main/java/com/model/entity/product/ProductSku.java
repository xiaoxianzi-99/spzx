package com.model.entity.product;

import com.model.entity.base.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSku extends BaseEntity {

	private String skuCode;
	private String skuName;
	private Long productId;
	private String thumbImg;
	private BigDecimal salePrice;
	private BigDecimal marketPrice;
	private BigDecimal costPrice;
	private Integer stockNum;
	private Integer saleNum;
	private String skuSpec;
	private String weight;
	private String volume;
	private Integer status;

}