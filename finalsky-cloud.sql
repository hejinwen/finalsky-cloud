DROP TABLE IF EXISTS `sys_inventory_info`;
CREATE TABLE `sys_inventory_info`  (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `product_id` varchar(32) NOT NULL COMMENT '商品ID',
  `inventory_count` int(4) NOT NULL COMMENT '库存数量',
  `remark` varchar(256) NULL DEFAULT NULL COMMENT '备注',
  `status` int(4) NOT NULL COMMENT '数据状态 枚举：-2临时保存 -1删除 0停用 1启用 2已过时',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `IDX_SYS_INVENTORY_INFO_PRODUCT_ID`(`product_id`) USING BTREE
) ENGINE = InnoDB COMMENT = '商品库存信息表' ROW_FORMAT = Dynamic;

INSERT INTO `sys_inventory_info` VALUES ('1', '1', 100, NULL, 1, '2019-08-27 16:37:24', '2019-08-27 16:37:27');

DROP TABLE IF EXISTS `sys_order_info`;
CREATE TABLE `sys_order_info`  (
  `id` varchar(32) NOT NULL COMMENT '订单ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `order_number` varchar(50) NOT NULL COMMENT '订单号',
  `order_amount` int(4) NOT NULL COMMENT '订单状态',
  `order_date` datetime(0) NOT NULL COMMENT '下单时间',
  `order_status` int(4) NOT NULL COMMENT '订单状态',
  `receive_name` varchar(50) NOT NULL COMMENT '收货人姓名',
  `receive_address` varchar(150) NOT NULL COMMENT '收货人地址',
  `receive_phone` varchar(20) NOT NULL COMMENT '收货人电话',
  `remark` varchar(256) NULL DEFAULT NULL COMMENT '备注',
  `status` int(4) NOT NULL COMMENT '数据状态 枚举：-2临时保存 -1删除 0停用 1启用 2已过时',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `IDX_SYS_ORDER_INFO_USER_ID`(`user_id`) USING BTREE
) ENGINE = InnoDB COMMENT = '订单信息表' ROW_FORMAT = Dynamic;

INSERT INTO `sys_order_info` VALUES ('1', '1', '201908271616428350001', 218, '2019-08-27 16:17:06', 1, '张三', '广东省广州市天河区黄浦大道108号', '12345678900', NULL, 1, '2019-08-27 16:17:56', '2019-08-27 16:18:00');

DROP TABLE IF EXISTS `sys_order_product`;
CREATE TABLE `sys_order_product`  (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `order_id` varchar(32) NOT NULL COMMENT '订单ID',
  `product_id` varchar(32) NOT NULL COMMENT '订单ID',
  `product_price` decimal(18, 2) NOT NULL COMMENT '商品单价',
  `product_count` int(4) NOT NULL COMMENT '商品数量',
  `product_amount` int(4) NOT NULL COMMENT '商品总金额',
  `remark` varchar(256) NULL DEFAULT NULL COMMENT '备注',
  `status` int(4) NOT NULL COMMENT '数据状态 枚举：-2临时保存 -1删除 0停用 1启用 2已过时',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `IDX_SYS_ORDER_PRODUCT_ORDER_ID`(`order_id`) USING BTREE,
  INDEX `IDX_SYS_ORDER_PRODUCT_PRODUCT_ID`(`product_id`) USING BTREE
) ENGINE = InnoDB COMMENT = '订单商品表' ROW_FORMAT = Dynamic;

INSERT INTO `sys_order_product` VALUES ('1', '1', '1', 109.00, 2, 218, NULL, 1, '2019-08-27 16:16:01', '2019-08-27 16:16:04');

DROP TABLE IF EXISTS `sys_product_info`;
CREATE TABLE `sys_product_info`  (
  `id` varchar(32) NOT NULL COMMENT '商品ID',
  `code` varchar(50) NOT NULL COMMENT '商品编码',
  `name` varchar(50) NOT NULL COMMENT '商品名称',
  `unit_price` decimal(18, 2) NOT NULL COMMENT '单价',
  `picture` varchar(150) NULL DEFAULT NULL COMMENT '商品图片',
  `remark` varchar(256) NULL DEFAULT NULL COMMENT '备注',
  `status` int(4) NOT NULL COMMENT '数据状态 枚举：-2临时保存 -1删除 0停用 1启用 2已过时',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

INSERT INTO `sys_product_info` VALUES ('1', '201908270001', 'JAVA编程思想', 109.00, NULL, 'JAVA编程指南宝典', 1, '2019-08-27 16:14:43', '2019-08-27 16:14:46');

DROP TABLE IF EXISTS `sys_shopping_cart`;
CREATE TABLE `sys_shopping_cart`  (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `user_id` varchar(32) NULL DEFAULT NULL COMMENT '用户ID',
  `product_id` varchar(32) NULL DEFAULT NULL COMMENT '商品ID',
  `count` int(4) NULL DEFAULT NULL COMMENT '商品数量',
  `remark` varchar(256) NULL DEFAULT NULL COMMENT '备注',
  `status` int(4) NOT NULL COMMENT '数据状态 枚举：-2临时保存 -1删除 0停用 1启用 2已过时',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `IDX_SYS_SHOPPING_CART_USER_ID`(`user_id`) USING BTREE,
  INDEX `IDX_SYS_SHOPPING_CART_PRODUCT_ID`(`product_id`) USING BTREE
) ENGINE = InnoDB COMMENT = '购物车信息表' ROW_FORMAT = Dynamic;

INSERT INTO `sys_shopping_cart` VALUES ('1', '1', '1', 4, '5', 1, '2019-08-26 18:03:22', '2019-08-27 16:12:33');

DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info`  (
  `id` varchar(32) NOT NULL COMMENT '人员ID',
  `name` varchar(50) NULL DEFAULT NULL COMMENT '人员名称',
  `sex` int(4) NULL DEFAULT NULL COMMENT '性别：0-男;1-女;',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `id_card` varchar(18) NULL DEFAULT NULL COMMENT '身份证号',
  `mobile` varchar(20) NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(256) NULL DEFAULT NULL COMMENT '住址',
  `loginable` int(4) NULL DEFAULT NULL COMMENT '是否登陆',
  `login_name` varchar(30) NULL DEFAULT NULL COMMENT '登陆名',
  `login_password` varchar(50) NULL DEFAULT NULL COMMENT '登陆密码',
  `remark` varchar(256) NULL DEFAULT NULL COMMENT '备注',
  `status` int(4) NOT NULL COMMENT '数据状态 枚举：-2临时保存 -1删除 0停用 1启用 2已过时',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `IDX_SYS_USER_INFO_LOGIN_NAME`(`login_name`) USING BTREE
) ENGINE = InnoDB COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

INSERT INTO `sys_user_info` VALUES ('1', '张三', 0, '2019-08-22', '123456789987654321', '12345678900', '123456@qq.com', '广东省广州市', 1, 'zhangs', '123456', NULL, 1, '2019-08-22 15:57:08', '2019-08-22 15:57:11');
