package com.manager.demo;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileUploader {
  public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
    try {
      // 创建minioClient客户端
      MinioClient minioClient =
              MinioClient.builder()
                      .endpoint("http://127.0.0.1:9001")
                      .credentials("admin", "admin123456")
                      .build();

      // 判断是否存在指定的桶
      boolean found =
              minioClient.bucketExists(BucketExistsArgs.builder().bucket("spzx-bucket").build());
      if (!found) {
        // 不存在则创建
        minioClient.makeBucket(MakeBucketArgs.builder().bucket("spzx-bucket").build());
      } else {
        System.out.println("Bucket 'asiatrip' already exists.");
      }
      //上传
      FileInputStream fis = new FileInputStream("D://001.jpg") ;

      minioClient.putObject(
              PutObjectArgs.builder().bucket("spzx-bucket")
                      .object("001.jpg")
                      .stream(fis, fis.available(),-1)
                      //.contentType("video.mp4")
                      .build()
      );
      fis.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}