package com.whoiszxl.edu.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

/**
 * 上传接口
 *
 * @author whoiszxl
 * @date 2021/7/12
 */
public interface UploaderService {

    /**
     * 指定路径上传字节数据到云存储中
     * @param data 字节数据
     * @param path 云存储文件路径
     * @return 图片HTTP地址
     * @throws Exception
     */
    String upload(byte[] data, String path) throws Exception;

    /**
     * 指定路径上传文件流到云存储中
     * @param inputStream 文件流
     * @param path 云存储文件路径
     * @return 图片HTTP地址
     * @throws Exception
     */
    String upload(InputStream inputStream, String path) throws Exception;

    /**
     * 指定路径上传multipartFile文件到云存储中
     * @param multipartFile multipart文件
     * @param path 云存储文件路径
     * @return 图片HTTP地址
     * @throws Exception
     */
    String upload(MultipartFile multipartFile, String path) throws Exception;

    /**
     * 指定路径上传文件对象到云存储中
     * @param file 文件对象
     * @param path 云存储文件路径
     * @return 图片HTTP地址
     * @throws Exception
     */
    String upload(File file, String path) throws Exception;

    String getBaseUrl();

}
