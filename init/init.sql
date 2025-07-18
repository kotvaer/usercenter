DROP TABLE IF EXISTS `user`;
-- Create database if it does not exist
CREATE DATABASE IF NOT EXISTS use_center;

-- Use the created database
USE use_center;

-- Create user table
CREATE TABLE IF NOT EXISTS `user`
(
    `id`          BIGINT AUTO_INCREMENT COMMENT '主键ID',
    `name`        VARCHAR(64) NOT NULL COMMENT '用户名',
    `gender`      TINYINT  DEFAULT 0 COMMENT '性别(0未知 1男 2女)',
    `phone`       VARCHAR(20)  NOT NULL COMMENT '手机号',
    `email`       VARCHAR(255) UNIQUE COMMENT '邮箱',
    `address`     VARCHAR(255) COMMENT '地址',
    `is_deleted`  TINYINT  DEFAULT 0 COMMENT '是否删除(0正常 1删除)',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_name` (`name`),
    UNIQUE KEY `uk_phone` (`phone`),
    INDEX `idx_phone` (`phone`)
) COMMENT ='用户表' ENGINE = InnoDB
                    DEFAULT CHARSET = utf8mb4;

-- Initial data for user table
INSERT INTO `user` (`name`, `gender`, `phone`, `email`, `address`, `is_deleted`) VALUES
('admin', 1, '13800000000', 'admin@example.com', 'Admin Address', 0),
('testuser', 0, '13911111111', 'test@example.com', 'Test User Address', 0);