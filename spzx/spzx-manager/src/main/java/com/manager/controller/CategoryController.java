package com.manager.controller;

import com.manager.service.CategoryService;
import com.model.entity.product.Category;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/17
 **/
@RestController
@RequestMapping(value = "/admin/product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    /**
     * 根据父id查询分类
     * @return
     */
    @GetMapping(value = "/findCategoryByParentId/{parentId}")
    public Result<List<Category>> findCategoryByParentId(@PathVariable Long parentId) {
        List<Category> categoryList = categoryService.findCategoryByParentId(parentId);

        return Result.build(categoryList, ResultCodeEnum.SUCCESS);
    }
    /*
       * 导出数据
     */
    @GetMapping("exportData")
    public void exportData(HttpServletResponse response) throws IOException {
        categoryService.exportData(response);
    }
    /**
     * 导入数据
     */
    @PostMapping("importData")
    public Result importData(MultipartFile file) {
        categoryService.importData(file);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }

}
