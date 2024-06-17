package com.example.demo.security.config;


import com.example.demo.security.domain.SecurityProvider;
import com.example.demo.security.filter.SecurityFilter;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@RequiredArgsConstructor
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final SecurityProvider provider;

    public void configure(HttpSecurity http) throws Exception {
        SecurityFilter filter = new SecurityFilter(provider);



    }
}
