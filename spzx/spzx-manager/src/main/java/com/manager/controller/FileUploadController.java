package com.manager.controller;

import com.manager.service.FileUploadService;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/13
 **/
@RestController
@RequestMapping(value = "/admin/system")
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;
    @PostMapping(value = "/fileUpload")
    public Result<String> fileUpload(@RequestParam(value = "file")MultipartFile multipartFile) {
        String url = fileUploadService.fileUpload(multipartFile);
        return Result.build(url, ResultCodeEnum.SUCCESS);
    }
}
