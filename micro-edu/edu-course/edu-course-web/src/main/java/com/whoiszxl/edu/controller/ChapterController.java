package com.whoiszxl.edu.controller;


import com.whoiszxl.edu.bean.ResponseResult;
import com.whoiszxl.edu.entity.vo.ChapterVO;
import com.whoiszxl.edu.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程章节表 前端控制器
 * </p>
 *
 * @author whoiszxl
 * @since 2021-07-12
 */
@CrossOrigin
@RestController
@RequestMapping("/course/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping("/{courseId}")
    public ResponseResult getChapterByCourseId(@PathVariable String courseId) {
        List<ChapterVO> list = chapterService.getChapterByCourseId(courseId);
        return ResponseResult.buildSuccess(list);
    }
}

