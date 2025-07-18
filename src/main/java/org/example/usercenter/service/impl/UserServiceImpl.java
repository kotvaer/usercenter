package org.example.usercenter.service.impl;

import org.example.usercenter.model.domain.User;
import org.example.usercenter.service.UserService;
import org.example.usercenter.mapper.UserMapper;
import org.example.usercenter.vo.Result;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

import java.util.List;

/**
 * @author lanran
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2025-07-17 10:00:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Result<Boolean> save(User user) {
        User selected = userMapper.selectByPhone(user.getPhone());
        if (selected != null) {
            return Result.failure(400, "手机号已存在");
        }
        boolean saved = userMapper.insert(user) > 0;
        if (saved) {
            return Result.success(true);
        } else {
            return Result.failure(500, "新增用户失败");
        }
    }

    @Override
    public Result<User> getById(Long id) {
        return Result.success(userMapper.selectById(id));
    }

    @Override
    public Result<List<User>> list() {
        return Result.success(userMapper.selectAll());
    }

    @Override
    public Result<User> getByName(String name) {
        return Result.success(userMapper.selectByName(name));
    }


    @Override
    public Result<Boolean> updateById(User user) {
        return Result.success(userMapper.updateById(user) > 0);
    }

    @Override
    public Result<Boolean> removeById(Long id) {
        return Result.success(userMapper.deleteById(id) > 0);
    }

    @Override
    public Result<User> getByPhone(String phone) {
        return Result.success(userMapper.selectByPhone(phone));
    }


    @Override
    public Result<Integer> count() {
        return Result.success(userMapper.count());
    }
}
