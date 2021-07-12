package com.whoiszxl.edu.service;

import com.whoiszxl.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whoiszxl.edu.entity.vo.ChapterVO;

import java.util.List;

/**
 * <p>
 * 课程章节表 服务类
 * </p>
 *
 * @author whoiszxl
 * @since 2021-07-12
 */
public interface ChapterService extends IService<Chapter> {

    /**
     * 通过课程ID获取课程章节
     * @param courseId 课程ID
     * @return
     */
    List<ChapterVO> getChapterByCourseId(String courseId);
}
