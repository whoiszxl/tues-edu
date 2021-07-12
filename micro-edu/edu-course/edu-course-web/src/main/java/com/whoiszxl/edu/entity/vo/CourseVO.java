package com.whoiszxl.edu.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 课程VO对象
 *
 * @author whoiszxl
 * @date 2021/7/12
 */
@Data
public class CourseVO {

    @ApiModelProperty(value = "课程主键ID")
    private Long id;

    @ApiModelProperty(value = "课程讲师ID")
    private Long teacherId;

    @ApiModelProperty(value = "课程分类ID")
    private Long categoryId;

    @ApiModelProperty(value = "课程分类父级ID")
    private Long parentParentId;

    @ApiModelProperty(value = "课程标题")
    private String title;

    @ApiModelProperty(value = "课程销售价格（0：免费）")
    private BigDecimal price;

    @ApiModelProperty(value = "总课时")
    private Integer lessonNum;

    @ApiModelProperty(value = "课程封面图片地址")
    private String cover;

    @ApiModelProperty(value = "课程详情")
    private String detail;

}
