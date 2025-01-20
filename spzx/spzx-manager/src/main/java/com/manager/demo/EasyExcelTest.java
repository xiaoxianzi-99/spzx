package com.manager.demo;

import com.alibaba.excel.EasyExcel;
import com.manager.listener.ExcelListener;
import com.model.vo.product.CategoryExcelVo;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/18
 **/
public class EasyExcelTest {
    public static void main(String[] args) {
        String filePath = "D:\\write.xlsx";
        ExcelListener<CategoryExcelVo> excelListener = new ExcelListener<CategoryExcelVo>();
        EasyExcel.read(filePath, CategoryExcelVo.class, excelListener).sheet().doRead();
        excelListener.getDates().forEach(System.out::println);
        System.out.println("Hello EasyExcel");
    }
}
