package org.example.usercenter.service;

import org.example.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author lanran
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2025-07-17 10:00:00
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名获取用户
     * @param name 用户名
     * @return 用户对象
     */
    User getByName(String name);
}
