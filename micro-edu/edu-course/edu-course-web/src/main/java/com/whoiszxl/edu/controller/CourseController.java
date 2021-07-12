package com.whoiszxl.edu.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.whoiszxl.edu.bean.ResponseResult;
import com.whoiszxl.edu.entity.vo.CourseVO;
import com.whoiszxl.edu.service.CourseService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程表 前端控制器
 * </p>
 *
 * @author whoiszxl
 * @since 2021-07-12
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/course/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("add")
    @ApiOperation(value = "新增课程", notes = "新增课程", response = Long.class)
    public ResponseResult<Long> addCourse(@RequestBody CourseVO courseVO) {
        Long id = courseService.addCourse(courseVO);
        return ResponseResult.buildSuccess(id);
    }


}

