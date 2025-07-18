package org.example.usercenter.service;

import org.example.usercenter.model.dao.User;
import org.example.usercenter.model.vo.Result;
import org.example.usercenter.model.vo.UserVO;

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
    Result<Boolean> save(User user);

    /**
     * 根据ID获取用户
     * @param id 用户ID
     * @return 用户对象
     */
    Result<UserVO> getById(Long id);

    /**
     * 获取所有用户
     * @return 用户列表
     */
    Result<List<UserVO>> list();

    /**
     * 根据用户名获取用户
     * @param name 用户名
     * @return 用户对象
     */
    Result<UserVO> getByName(String name);

    /**
     * 更新用户
     * @param user 用户对象
     * @return 是否成功
     */
    Result<Boolean> updateById(User user);


    /**
     * 删除用户
     * @param id 用户ID
     * @return 是否成功
     */
    Result<Boolean> removeById(Long id);

    Result<UserVO> getByPhone(String phone);

    Result<Integer> count();
}
