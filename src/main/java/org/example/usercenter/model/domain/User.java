package org.example.usercenter.model.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 */
@Data
public class User implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别(0未知 1男 2女)
     */
    private Integer gender;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 是否删除(0正常 1删除)
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
