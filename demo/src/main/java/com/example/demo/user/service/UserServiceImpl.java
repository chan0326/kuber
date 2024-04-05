package com.example.demo.user.service;


import com.example.demo.common.component.PageRequestVo;
import com.example.demo.user.model.UserDto;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public UserDto save(UserDto userDto) {
        return entityToDto(Optional.of(userRepository.save(dtoToEntity(userDto))));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<UserDto> findAll(PageRequestVo vo) {
        return null;
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return Optional.of(entityToDto(userRepository.findById(id)));
    }

    @Override
    public Long count() {
        return userRepository.count();
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
}
