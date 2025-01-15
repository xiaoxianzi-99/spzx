package com.manager.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/13
 **/
public interface FileUploadService {
    String fileUpload(MultipartFile multipartFile);
}
