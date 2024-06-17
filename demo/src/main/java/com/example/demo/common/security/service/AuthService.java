package com.example.demo.common.security.service;


import com.example.demo.common.component.MessengerVo;
import com.example.demo.user.domain.UserDto;

public interface AuthService {
    MessengerVo login(UserDto param);

}
