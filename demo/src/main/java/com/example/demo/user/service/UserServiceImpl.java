package com.example.demo.user.service;


import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.component.security.JwtProvider;
import com.example.demo.user.domain.UserModel;
import com.example.demo.user.domain.UserDto;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;




    @Override
    public List<UserDto> findAll() {
        return List.of();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public MessengerVo save(UserDto userDto) {
        return null;
    }

    @Override
    public MessengerVo deleteById(Long id) {
        return null;
    }

    @Override
    public MessengerVo modify(UserDto userDto) {
        return null;
    }
}
