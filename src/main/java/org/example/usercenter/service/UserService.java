package org.example.usercenter.service;

import org.example.usercenter.model.domain.User;

import java.util.List;

/**
 * @author lanran
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2025-07-17 10:00:00
 */
public interface UserService {

    /**
     * 保存用户
     * @param user 用户对象
     * @return 是否成功
     */
    boolean save(User user);

    /**
     * 根据ID获取用户
     * @param id 用户ID
     * @return 用户对象
     */
    User getById(Long id);

    /**
     * 获取所有用户
     * @return 用户列表
     */
    List<User> list();

    /**
     * 根据用户名获取用户
     * @param name 用户名
     * @return 用户对象
     */
    User getByName(String name);

    /**
     * 更新用户
     * @param user 用户对象
     * @return 是否成功
     */
    boolean updateById(User user);


    /**
     * 删除用户
     * @param id 用户ID
     * @return 是否成功
     */
    boolean removeById(Long id);

    User getByPhone(String phone);

    Integer count();
}
