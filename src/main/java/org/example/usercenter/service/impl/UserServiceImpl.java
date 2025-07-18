package org.example.usercenter.service.impl;

import org.example.usercenter.model.dao.User;
import org.example.usercenter.service.UserService;
import org.example.usercenter.mapper.UserMapper;
import org.example.usercenter.mapper.UserVoMapper;
import org.example.usercenter.model.vo.Result;
import org.example.usercenter.model.vo.UserVO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

import java.util.stream.Collectors;

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
    public Result<UserVO> getById(Long id) {
        User user = userMapper.selectById(id);
        return Result.success(UserVoMapper.INSTANCE.toUserVO(user));
    }

    @Override
    public Result<List<UserVO>> list() {
        List<User> users = userMapper.selectAll();
        List<UserVO> userVOs = users.stream()
                .map(UserVoMapper.INSTANCE::toUserVO)
                .collect(Collectors.toList());
        return Result.success(userVOs);
    }

    @Override
    public Result<UserVO> getByName(String name) {
        User user = userMapper.selectByName(name);
        return Result.success(UserVoMapper.INSTANCE.toUserVO(user));
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
    public Result<UserVO> getByPhone(String phone) {
        User user = userMapper.selectByPhone(phone);
        return Result.success(UserVoMapper.INSTANCE.toUserVO(user));
    }


    @Override
    public Result<Integer> count() {
        return Result.success(userMapper.count());
    }
}
