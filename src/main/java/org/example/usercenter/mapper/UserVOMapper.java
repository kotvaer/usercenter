package org.example.usercenter.mapper;

import org.example.usercenter.model.dao.User;
import org.example.usercenter.model.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserVOMapper {
    UserVOMapper INSTANCE = Mappers.getMapper(UserVOMapper.class);

    UserVO toUserVO(User user);

    List<UserVO> toUserVOList(List<User> users);

    List<User> toUserList(List<UserVO> userVOs);
}