package com.whoiszxl.edu.service.impl;

import com.whoiszxl.edu.entity.Category;
import com.whoiszxl.edu.mapper.CategoryMapper;
import com.whoiszxl.edu.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程分表表 服务实现类
 * </p>
 *
 * @author whoiszxl
 * @since 2021-07-12
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
