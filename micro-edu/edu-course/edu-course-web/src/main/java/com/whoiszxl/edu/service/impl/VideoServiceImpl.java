package com.whoiszxl.edu.service.impl;

import com.whoiszxl.edu.entity.Video;
import com.whoiszxl.edu.mapper.VideoMapper;
import com.whoiszxl.edu.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频表 服务实现类
 * </p>
 *
 * @author whoiszxl
 * @since 2021-07-12
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}
