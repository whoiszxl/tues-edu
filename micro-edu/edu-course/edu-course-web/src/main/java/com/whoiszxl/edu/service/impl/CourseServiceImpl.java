package com.whoiszxl.edu.service.impl;

import com.whoiszxl.edu.bean.ResponseResult;
import com.whoiszxl.edu.entity.Course;
import com.whoiszxl.edu.entity.CourseDetail;
import com.whoiszxl.edu.entity.vo.CourseVO;
import com.whoiszxl.edu.exception.ExceptionCatcher;
import com.whoiszxl.edu.mapper.CourseMapper;
import com.whoiszxl.edu.service.CourseDetailService;
import com.whoiszxl.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程表 服务实现类
 * </p>
 *
 * @author whoiszxl
 * @since 2021-07-12
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseDetailService courseDetailService;

    @Override
    public Long addCourse(CourseVO courseVO) {
        //1. 课程入库
        Course course = new Course();
        BeanUtils.copyProperties(courseVO, course);
        int insertResult = baseMapper.insert(course);
        if(insertResult == 0) {
            ExceptionCatcher.catchValidateEx(ResponseResult.buildError("课程新增失败"));
        }

        //2. 课程详情入库
        Long courseId = course.getId();
        CourseDetail courseDetail = new CourseDetail();
        courseDetail.setDetail(courseVO.getDetail());
        courseDetail.setId(courseId);
        courseDetailService.save(courseDetail);
        return courseId;
    }
}
