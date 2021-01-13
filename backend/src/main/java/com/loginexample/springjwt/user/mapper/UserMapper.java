package com.loginexample.springjwt.user.mapper;

import com.loginexample.springjwt.user.dto.UserDTO;
import com.loginexample.springjwt.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toModel(UserDTO userDTO);
    UserDTO toDTO(User user);
}
