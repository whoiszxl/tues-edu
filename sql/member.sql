---------------------------------------------------
--------------会员模块-----------------------------
---------------------------------------------------
DROP TABLE IF EXISTS `ums_member`;
CREATE TABLE `ums_member`(
	`id` bigint(11) NOT NULL COMMENT '主键ID',
    `openid` varchar(128) DEFAULT NULL COMMENT '微信openid',
	`username` varchar(16) NOT NULL COMMENT '会员名',
	`password` varchar(100) NOT NULL COMMENT '密码',
	`pay_password` varchar(100) DEFAULT '' COMMENT '支付密码',
    `google_key` varchar(32) DEFAULT '' COMMENT '谷歌验证码',
	`google_status` int(1) DEFAULT '0' COMMENT '谷歌验证码是否开启，默认0不开启, 1开启',
	`real_name` varchar(16) DEFAULT '' COMMENT '真实姓名',
	`email` varchar(50) DEFAULT '' COMMENT '邮箱',
	`phone` varchar(16) DEFAULT '' COMMENT '手机',
	`status` tinyint(2) DEFAULT 1 COMMENT '状态(0：无效 1：有效)',
	`created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`id`),
	UNIQUE KEY `idx_username` (`username`),
	UNIQUE KEY `idx_phone` (`phone`)
) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '会员表';


DROP TABLE IF EXISTS `ums_member_info`;
CREATE TABLE `ums_member_info`(
	`member_id` bigint(11) NOT NULL COMMENT '用户ID',
	`gender` tinyint(1) DEFAULT 0 COMMENT '性别(0:未知 1:男；2:女)',
    `birthday` datetime DEFAULT NULL COMMENT '生日',
	`country_code` varchar(5) DEFAULT '' COMMENT '国家码',
	`country` varchar(100) DEFAULT '' COMMENT '国家',
	`province` varchar(100) DEFAULT '' COMMENT '省份',
	`city` varchar(30) DEFAULT '' COMMENT '城市',
	`district` varchar(200) DEFAULT '' COMMENT '区域',
	`grade_level` varchar(255) DEFAULT '' COMMENT '会员等级',
	`login_count` int(11) NOT NULL DEFAULT 0 COMMENT '会员登录次数',
	`login_error_count` int(11) NOT NULL DEFAULT 0 COMMENT '会员登录错误次数',
	`last_login` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录',
	`created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`member_id`)
) ENGINE = InnoDB CHARSET = utf8mb4 COMMENT '会员详情表';

DROP TABLE IF EXISTS `ums_member_address`;
CREATE TABLE `ums_member_address` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `member_id` bigint(20) NOT NULL COMMENT '用户ID',
  `reciver_name` varchar(1024) NOT NULL COMMENT '收货人',
  `reciver_phone` varchar(1024) NOT NULL COMMENT '收货人电话号码',
  `province` varchar(1024) NOT NULL COMMENT '省',
  `city` varchar(1024) NOT NULL COMMENT '市',
  `district` varchar(1024) NOT NULL COMMENT '区',
  `detail_address` varchar(1024) NOT NULL COMMENT '收货地址',
  `is_default` tinyint(1) NOT NULL default 0 comment '是否默认 1:默认 2:非默认',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员收货地址表';