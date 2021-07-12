package com.whoiszxl.edu.controller;

import com.whoiszxl.edu.bean.ResponseResult;
import com.whoiszxl.edu.service.UploaderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * 上传接口
 *
 * @author whoiszxl
 * @date 2021/7/12
 */
@Slf4j
@Api(tags = "文件上传接口")
@CrossOrigin
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploaderService uploaderService;

    @ApiOperation(value = "上传文件")
    @PostMapping
    public ResponseResult<String> upload(@RequestParam("file") MultipartFile file) {
        try {
            String filePath = uploaderService.upload(file,
                    UUID.randomUUID().toString().replace("-", "") + file.getOriginalFilename());
            return ResponseResult.buildSuccess(filePath);
        } catch (Exception e) {
            log.error("上传文件出错", e);
            return ResponseResult.buildError();
        }
    }
}
