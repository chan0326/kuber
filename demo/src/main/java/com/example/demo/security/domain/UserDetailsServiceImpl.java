package com.example.demo.security.domain;
import com.example.demo.user.domain.UserModel;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> user = Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found with username: "+username));
                return UserDetailsImpl.build(user.get());
    }
}
