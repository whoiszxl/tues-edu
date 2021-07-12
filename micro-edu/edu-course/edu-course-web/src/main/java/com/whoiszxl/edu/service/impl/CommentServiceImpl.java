package com.whoiszxl.edu.service.impl;

import com.whoiszxl.edu.entity.Comment;
import com.whoiszxl.edu.mapper.CommentMapper;
import com.whoiszxl.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程评论表 服务实现类
 * </p>
 *
 * @author whoiszxl
 * @since 2021-07-12
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
