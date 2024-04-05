package com.example.demo.user.service;

import com.example.demo.common.command.CommandService;
import com.example.demo.common.query.QueryService;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;

import java.util.Optional;


public interface UserService extends CommandService<UserDto>, QueryService<UserDto> {
    default User dtoToEntity(UserDto dto){
        return User.builder().build();
    } //디티오를 엔티티로 바꿈

    default UserDto entityToDto(Optional<User> optional){
        return UserDto.builder().build();
    } // 엔티티를 디티오로 바꿈 이걸 하는 이유는 원투매니때문에 발생




}
