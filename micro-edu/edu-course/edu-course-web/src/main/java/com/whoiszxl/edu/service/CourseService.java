package com.whoiszxl.edu.service;

import com.whoiszxl.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whoiszxl.edu.entity.vo.CourseVO;

/**
 * <p>
 * 课程表 服务类
 * </p>
 *
 * @author whoiszxl
 * @since 2021-07-12
 */
public interface CourseService extends IService<Course> {

    /**
     * 添加课程
     * @param courseVO 课程信息
     * @return
     */
    Long addCourse(CourseVO courseVO);
}
