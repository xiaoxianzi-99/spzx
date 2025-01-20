package com.model.vo.product;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/18
 **/
@Data
public class CategoryExcelVo {
    @ExcelProperty(value = "id" ,index = 0)
    private Long id;

    @ExcelProperty(value = "名称" ,index = 1)
    private String name;

    @ExcelProperty(value = "图片url" ,index = 2)
    private String imageUrl ;

    @ExcelProperty(value = "上级id" ,index = 3)
    private Long parentId;

    @ExcelProperty(value = "状态" ,index = 4)
    private Integer status;

    @ExcelProperty(value = "排序" ,index = 5)
    private Integer orderNum;
}
