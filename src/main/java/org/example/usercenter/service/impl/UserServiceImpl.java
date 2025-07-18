package org.example.usercenter.service.impl;

import org.example.usercenter.mapper.UserVOMapper;
import org.example.usercenter.model.dao.User;
import org.example.usercenter.service.UserService;
import org.example.usercenter.mapper.UserMapper;
import org.example.usercenter.model.vo.Result;
import org.example.usercenter.model.vo.UserVO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> save(User user) {
        User selected = userMapper.selectByPhone(user.getPhone());
        if (selected != null) {
            return Result.failure(400, "手机号已存在");
        }
        userMapper.insert(user);
        return Result.success(true);
    }

    @Override
    public Result<UserVO> getById(Long id) {
        User user = userMapper.selectById(id);
        return Result.success(UserVOMapper.INSTANCE.toUserVO(user));
    }

    @Override
    public Result<List<UserVO>> list() {
        List<User> users = userMapper.selectAll();
        List<UserVO> userVOs = UserVOMapper.INSTANCE.toUserVOList(users);
        return Result.success(userVOs);
    }

    @Override
    public Result<Integer> count() {
        return Result.success(userMapper.count());
    }

    @Override
    public Result<UserVO> getByName(String name) {
        User user = userMapper.selectByName(name);
        return Result.success(UserVOMapper.INSTANCE.toUserVO(user));
    }

    @Override
    public Result<UserVO> getByPhone(String phone) {
        User user = userMapper.selectByPhone(phone);
        return Result.success(UserVOMapper.INSTANCE.toUserVO(user));
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateById(User user) {
        return Result.success(userMapper.updateById(user) > 0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> removeById(Long id) {
        return Result.success(userMapper.deleteById(id) > 0);
    }

}
