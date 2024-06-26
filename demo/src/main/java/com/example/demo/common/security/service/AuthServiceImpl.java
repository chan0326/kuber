package com.example.demo.common.security.service;


import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.component.security.JwtProvider;
import com.example.demo.user.domain.UserDto;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


@Service
@Log4j2
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository repo;
    private final JwtProvider jwt;

    @Override
    public MessengerVo login(UserDto dto) {
        boolean flag = repo.findUserByUsername(
                dto.getUsername()).get().getPassword().equals(dto.getPassword());
        return MessengerVo.builder()
                .message(flag ? "SUCCESS" : "FAILURE")
                .accessToken(flag ? jwt.createToken(dto) : "Noe")
                .build();
    }

}
