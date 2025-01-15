package com.manager.service.impl;

import cn.hutool.core.date.DateUtil;
import com.manager.properties.MinioProperties;
import com.manager.service.FileUploadService;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/13
 **/
@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private MinioProperties minioProperties;

    /**
     * 文件上传
     *
     * @param multipartFile
     * @return
     */
    @Override
    public String fileUpload(MultipartFile multipartFile) {
        String fileUrl = null;
        try {
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(minioProperties.getEndpointUrl())
                    .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                    .build();
            // 判断是否存在指定的桶
            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProperties.getBucketName()).build());
            if (!found) {
                // 不存在则创建
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioProperties.getBucketName()).build());
            } else {
                System.out.println("Bucket 'asiatrip' already exists.");
            }
            //文件夹
            String pathDir = DateUtil.format(new Date(), "yyyyMMdd");
            //使用uuid生成文件名
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String fileName = pathDir + "/" + uuid + multipartFile.getOriginalFilename();

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(minioProperties.getBucketName())
                            .object(fileName)
                            .stream(multipartFile.getInputStream(), multipartFile.getSize(), -1)
                            .contentType(multipartFile.getContentType())
                            .build()
            );
            //拼接上传后的文件路径
            fileUrl = minioProperties.getEndpointUrl() + "/" + minioProperties.getBucketName() + "/" + fileName;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
    }
}
