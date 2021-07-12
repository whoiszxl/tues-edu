package com.whoiszxl.edu.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * aliyun OSS 上传工具
 *
 * @author whoiszxl
 * @date 2021/7/12
 */
@Service
public class AliyunOSSUploader implements UploaderService {

    @Value("${oss.endPoint}")
    private String endPoint;

    @Value("${oss.accessKey}")
    private String accessKeyId;

    @Value("${oss.accessSecret}")
    private String accessKeySecret;

    @Value("${oss.bucketName}")
    private String bucketName;

    @Value("${oss.httpUrl}")
    private String httpUrl;


    @Override
    public String upload(byte[] data, String path) throws Exception {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(InputStream inputStream, String path) throws Exception {
        OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
        try {
            if(path.startsWith("/")) {
                path = path.substring(1);
            }
            ossClient.putObject(bucketName, path, inputStream);
            
            //把上传之后文件路径返回
            //需要把上传到阿里云oss路径手动拼接出来
            //  https://edu-guli-1010.oss-cn-beijing.aliyuncs.com/01.jpg
            String url = "https://"+bucketName+"."+endPoint+"/"+path;
            return url;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            ossClient.shutdown();
        }
    }

    @Override
    public String upload(MultipartFile multipartFile, String path) throws Exception {
        return upload(multipartFile.getInputStream(), path);
    }

    @Override
    public String upload(File file, String path) throws Exception {
        return upload(new FileInputStream(file), path);
    }

    @Override
    public String getBaseUrl() {
        return httpUrl;
    }
}
