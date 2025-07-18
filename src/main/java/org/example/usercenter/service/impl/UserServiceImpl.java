package org.example.usercenter.service.impl;

import org.example.usercenter.model.domain.User;
import org.example.usercenter.service.UserService;
import org.example.usercenter.mapper.UserMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

import java.util.List;

/**
 * @author lanran
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2025-07-17 10:00:00
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean save(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public User getById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> list() {
        return userMapper.selectAll();
    }

    @Override
    public User getByName(String name) {
        return userMapper.selectByName(name);
    }



    @Override
    public boolean updateById(User user) {
        return userMapper.updateById(user) > 0;
    }

    @Override
    public boolean removeById(Long id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public User getByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    /**
     * @return
     */
    @Override
    public Integer count() {
        return userMapper.count();
    }
}
