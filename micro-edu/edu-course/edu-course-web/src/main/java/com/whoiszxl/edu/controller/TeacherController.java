package com.whoiszxl.edu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whoiszxl.edu.bean.ResponseResult;
import com.whoiszxl.edu.entity.Teacher;
import com.whoiszxl.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师表 前端控制器
 * </p>
 *
 * @author whoiszxl
 * @since 2021-07-12
 */
@Api(tags = "讲师相关接口")
@CrossOrigin
@RestController
@RequestMapping("/course/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/save")
    @ApiOperation(value = "新增讲师", notes = "新增一个讲师", response = Boolean.class)
    public ResponseResult teacherSave(@RequestBody Teacher teacher) {
        teacherService.save(teacher);
        return ResponseResult.buildSuccess();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询讲师", notes = "根据ID查询讲师", response = Teacher.class)
    public ResponseResult<Teacher> getTeacherById(@PathVariable String id){
        return ResponseResult.buildSuccess(teacherService.getById(id));
    }

    @GetMapping("/{page}/{size}")
    @ApiOperation(value = "分页查询讲师", notes = "传入页号与数量分页查询讲师列表", response = Teacher.class)
    public ResponseResult<List<Teacher>> teacherList(@PathVariable Long page, @PathVariable Long size) {
        IPage<Teacher> pageResult = teacherService.page(new Page<>(page, size), null);
        List<Teacher> records = pageResult.getRecords();
        return ResponseResult.buildSuccess(records);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "分页查询讲师", notes = "传入页号与数量分页查询讲师列表", response = Teacher.class)
    public ResponseResult updateTeacherById(@RequestBody Teacher teacher){
        teacherService.updateById(teacher);
        return ResponseResult.buildSuccess();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除讲师", notes = "通过讲师ID逻辑删除讲师", response = Boolean.class)
    public ResponseResult<Boolean> teacherRemove(@PathVariable String id) {
        return ResponseResult.buildSuccess(teacherService.removeById(Long.parseLong(id)));
    }

}

