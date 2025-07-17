package org.example.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.usercenter.model.domain.User;
import org.example.usercenter.service.UserService;
import org.example.usercenter.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author lanran
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2025-07-17 10:00:00
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public User getByName(String name) {
        return query().eq("name", name).one();
    }
}
