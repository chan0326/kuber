package com.example.demo.common.security.service;

import com.example.demo.common.component.MessengerVo;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface AuthService {
    MessengerVo modify(UserDto user);
    MessengerVo login(UserDto param);
    Optional<User> findUserByUsername(String username);
}
