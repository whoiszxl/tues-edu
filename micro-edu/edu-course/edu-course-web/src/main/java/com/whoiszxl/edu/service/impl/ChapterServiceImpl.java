package com.whoiszxl.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whoiszxl.edu.entity.Chapter;
import com.whoiszxl.edu.entity.vo.ChapterVO;
import com.whoiszxl.edu.mapper.ChapterMapper;
import com.whoiszxl.edu.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程章节表 服务实现类
 * </p>
 *
 * @author whoiszxl
 * @since 2021-07-12
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {


    @Override
    public List<ChapterVO> getChapterByCourseId(String courseId) {
        //1. 通过课程ID查询章节表中的所有记录
        List<Chapter> chapterList = baseMapper.selectList(new QueryWrapper<Chapter>().eq("course_id", courseId));

        //2. 查询章节中的小节


        return null;
    }
}
