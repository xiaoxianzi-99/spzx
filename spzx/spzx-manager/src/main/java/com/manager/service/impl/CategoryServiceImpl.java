package com.manager.service.impl;

import com.alibaba.excel.EasyExcel;
import com.manager.listener.CategoryExcelListener;
import com.manager.mapper.CategoryMapper;
import com.manager.service.CategoryService;
import com.model.entity.product.Category;
import com.model.vo.common.ResultCodeEnum;
import com.model.vo.product.CategoryExcelVo;
import com.service.exception.BusinessException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/17
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> findCategoryByParentId(Long parentId) {
        List<Category> categoryList = categoryMapper.findCategoryByParentId(parentId);
        for(Category category : categoryList){
            Long count =categoryMapper.countByParentId(category.getId());
            if(count > 0) category.setHasChildren(true);
        }
        return categoryList;
    }

    @Override
    public void exportData(HttpServletResponse response) throws IOException {
        //设置响应的mine类型
        response.setContentType("application/vnd.ms-excel");
        //设置utf-8编码，防止中文乱码
        response.setCharacterEncoding("UTF-8");
        //设置响应的文件名
        String fileName = URLEncoder.encode("分类数据", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");

        List<Category> categoryList = categoryMapper.selectCategory();
        List<CategoryExcelVo> categoryExcelVoList = categoryList.stream().map(category -> {
            CategoryExcelVo categoryExcelVo = new CategoryExcelVo();
            BeanUtils.copyProperties(category, categoryExcelVo);
            return categoryExcelVo;
        }).collect(Collectors.toList());
        EasyExcel.write(response.getOutputStream(), CategoryExcelVo.class).sheet("分类管理").doWrite(categoryExcelVoList);
    }
    public void importData(MultipartFile file) {
        try {
            //创建监听器对象，传递mapper对象
            CategoryExcelListener<CategoryExcelVo> categoryExcelVoCategoryExcelListener = new CategoryExcelListener(categoryMapper);
            //调用read方法读取excel数据
            EasyExcel.read(file.getInputStream(),
                    CategoryExcelVo.class,
                    categoryExcelVoCategoryExcelListener).sheet().doRead();
        } catch (IOException e) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR);
        }
    }
}
