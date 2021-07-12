
-- 1.课程表
CREATE TABLE `edu_course` (
  `id` bigint(32) NOT NULL COMMENT '课程主键ID',
  `teacher_id` bigint(32) NOT NULL COMMENT '课程讲师ID',
  `category_id` bigint(32) NOT NULL COMMENT '课程分类ID',
  `parent_parent_id` bigint(32) NOT NULL COMMENT '课程分类父级ID',
  `title` varchar(100) NOT NULL COMMENT '课程标题',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '课程销售价格（0：免费）',
  `lesson_num` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '总课时',
  `cover` varchar(255)  NOT NULL COMMENT '课程封面图片地址',
  `sale_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '销售数量',
  `view_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '浏览数量',
  `version` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '课程状态 1：未发布 2：审核中 3：已发布',
  `is_deleted` tinyint(3) DEFAULT NULL COMMENT '逻辑删除 1: 已删除， 0: 未删除',
  `created_by` varchar(50) NOT NULL COMMENT '创建者',
  `updated_by` varchar(50) NOT NULL COMMENT '更新者',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_title` (`title`),
  KEY `idx_category_id` (`category_id`),
  KEY `idx_teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程表';

-- 2.课程详情表
CREATE TABLE `edu_course_detail` (
  `id` bigint(32) NOT NULL COMMENT '课程详情主键ID',
  `detail` text COMMENT '课程详情',
  `created_by` varchar(50) NOT NULL COMMENT '创建者',
  `updated_by` varchar(50) NOT NULL COMMENT '更新者',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程详情表';

-- 3.课程视频表
CREATE TABLE `edu_video` (
  `id` bigint(32) NOT NULL COMMENT '视频ID',
  `course_id` bigint(32) NOT NULL COMMENT '课程ID',
  `chapter_id` bigint(32) NOT NULL COMMENT '章节ID',
  `title` varchar(50) NOT NULL COMMENT '节点名称',
  `video_source_id` varchar(100) DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100) DEFAULT NULL COMMENT '原始文件名称',
  `play_count` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '播放次数',
  `is_free` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否收费：0收费 1免费',
  `duration` float NOT NULL DEFAULT '0' COMMENT '视频时长（秒）',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '1:未上传 2:转码中  3:正常',
  `size` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '视频源文件大小（字节）',
  `version` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `sort` int(10) NOT NULL DEFAULT '0' COMMENT '排序字段',
  `created_by` varchar(50) NOT NULL COMMENT '创建者',
  `updated_by` varchar(50) NOT NULL COMMENT '更新者',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_chapter_id` (`chapter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程视频表';


-- 4.课程章节表
CREATE TABLE `edu_chapter` (
  `id` bigint(32) NOT NULL COMMENT '章节主键ID',
  `course_id` bigint(32) NOT NULL COMMENT '课程ID',
  `title` varchar(100) NOT NULL COMMENT '章节名称',
  `sort` int(10) NOT NULL DEFAULT '0' COMMENT '显示排序',
  `created_by` varchar(50) NOT NULL COMMENT '创建者',
  `updated_by` varchar(50) NOT NULL COMMENT '更新者',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程章节表';

-- 5.课程分类表
CREATE TABLE `edu_category` (
  `id` bigint(32) NOT NULL COMMENT '课程分类ID',
  `title` varchar(10) NOT NULL COMMENT '分类名称',
  `parent_id` bigint(32) NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int(10) NOT NULL DEFAULT '0' COMMENT '排序字段',
  `created_by` varchar(50) NOT NULL COMMENT '创建者',
  `updated_by` varchar(50) NOT NULL COMMENT '更新者',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程分表表';


-- 6.讲师表
CREATE TABLE `edu_teacher` (
  `id` bigint(32) NOT NULL COMMENT '讲师主键ID',
  `name` varchar(20) NOT NULL COMMENT '讲师姓名',
  `intro` varchar(500) NOT NULL DEFAULT '' COMMENT '讲师简介',
  `level` tinyint(10) NOT NULL COMMENT '头衔 1高级讲师 2首席讲师 3精英讲师',
  `avatar` varchar(255) DEFAULT NULL COMMENT '讲师头像',
  `course_count` int(10) NOT NULL DEFAULT '0' COMMENT '讲师的课程数量',
  `fans_count` int(10) NOT NULL DEFAULT '0' COMMENT '讲师的粉丝数量',
  `sort` int(10) NOT NULL DEFAULT '0' COMMENT '排序',
  `is_deleted` tinyint(3) DEFAULT NULL COMMENT '逻辑删除 1: 已删除， 0: 未删除',
  `created_by` varchar(50) NOT NULL COMMENT '创建者',
  `updated_by` varchar(50) NOT NULL COMMENT '更新者',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='讲师表';


-- 7.课程评论表
CREATE TABLE `edu_comment` (
  `id` bigint(32) NOT NULL COMMENT '评论ID',
  `course_id` bigint(32) NOT NULL COMMENT '课程id',
  `member_id` bigint(32) NOT NULL COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '会员头像',
  `content` varchar(500) DEFAULT NULL COMMENT '评论内容',
  `like` bigint(11) NOT NULL COMMENT '点赞数',
  `is_deleted` tinyint(3) DEFAULT NULL COMMENT '逻辑删除 1: 已删除， 0: 未删除',
  `created_by` varchar(50) NOT NULL COMMENT '创建者',
  `updated_by` varchar(50) NOT NULL COMMENT '更新者',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程评论表';


-- 8.课程收藏表
CREATE TABLE `edu_collect` (
  `id` bigint(32) NOT NULL COMMENT '收藏ID',
  `course_id` bigint(32) NOT NULL COMMENT '课程ID',
  `member_id` bigint(32) NOT NULL COMMENT '会员ID',
  `is_deleted` tinyint(3) DEFAULT NULL COMMENT '逻辑删除 1: 已删除， 0: 未删除',
  `created_by` varchar(50) NOT NULL COMMENT '创建者',
  `updated_by` varchar(50) NOT NULL COMMENT '更新者',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程收藏表';

-- 9.课程点赞表
CREATE TABLE `edu_like` (
  `id` bigint(32) NOT NULL COMMENT '收藏ID',
  `course_id` bigint(32) NOT NULL COMMENT '课程ID',
  `member_id` bigint(32) NOT NULL COMMENT '会员ID',
  `is_deleted` tinyint(3) DEFAULT NULL COMMENT '逻辑删除 1: 已删除， 0: 未删除',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程点赞表';