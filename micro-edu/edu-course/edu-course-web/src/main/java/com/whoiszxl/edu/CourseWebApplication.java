package com.whoiszxl.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 课程web服务启动类
 *
 * @author whoiszxl
 * @date 2021/7/12
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.whoiszxl.edu"})
@MapperScan(basePackages = {"com.whoiszxl.edu.mapper"})
public class CourseWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseWebApplication.class, args);
    }
}
