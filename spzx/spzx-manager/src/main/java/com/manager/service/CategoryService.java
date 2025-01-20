package com.manager.service;

import com.model.entity.product.Category;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/17
 **/
public interface CategoryService {
    List<Category> findCategoryByParentId(Long parentId);

    void exportData(HttpServletResponse response) throws IOException;

    void importData(MultipartFile file);
}
