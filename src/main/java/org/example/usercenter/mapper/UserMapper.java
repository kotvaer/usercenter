package org.example.usercenter.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.usercenter.model.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author lanran
 * @description 针对表【user(用户表)】的数据库操作Mapper
 * @createDate 2025-07-17 10:00:00
 * @Entity org.example.usercenter.model.domain.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
