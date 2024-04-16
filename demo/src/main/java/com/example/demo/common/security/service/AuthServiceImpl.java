package com.example.demo.common.security.service;

import com.example.demo.common.component.MessengerVo;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    @Override
    public MessengerVo modify(UserDto user) {
        return null;
    }


    @Override
    public MessengerVo login(UserDto param) {
        return MessengerVo.builder()
                .message( findUserByUsername(param.getUsername()).get().getPassword().equals( param.getPassword()) ? "SUCCESS":"FAILRE")
                .build();
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
