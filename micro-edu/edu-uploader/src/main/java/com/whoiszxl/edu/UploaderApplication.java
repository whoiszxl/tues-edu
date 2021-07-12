package com.whoiszxl.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 上传服务启动类
 *
 * @author whoiszxl
 * @date 2021/7/12
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.whoiszxl.edu"})
public class UploaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploaderApplication.class, args);
    }
}
