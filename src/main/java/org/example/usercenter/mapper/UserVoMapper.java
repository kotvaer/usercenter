package org.example.usercenter.mapper;

import org.example.usercenter.model.domain.User;
import org.example.usercenter.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserVoMapper {
    UserVoMapper INSTANCE = Mappers.getMapper(UserVoMapper.class);

    UserVO toUserVO(User user);
}