package com.example.demo.user.service;

import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import  static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional //데이터 롤백 어노테이션
public class UserServiceImplTest {
    @Autowired UserService service;
    @Autowired UserRepository userRepository;

    @Test
    @DisplayName("유저 회원수")
    void count() {
        Assertions.assertEquals(service.count(),15);

    }


    @Test
    void save() {
        User user= new User();

        user.setName("chan");
        user.setPassword("8912");
        user.setUsername("qw");
        user.setPhone("010-45");
        userRepository.save(user);
        Assertions.assertEquals(userRepository.existsByUsername("qw"),true);





    }

//    @Test
//    void deleteById() {
//        userRepository.deleteById(1L);
//
//
//    }

    @Test
    void findAll() {
        System.out.println( userRepository.findAll());
    }

    @Test
    void findById() {
        System.out.println(userRepository.findById(1L));
    }

    @Test
    void existsById() {
        Assertions.assertEquals(userRepository.existsById(1L),true);
        Assertions.assertEquals(userRepository.existsById(17L),false);
    }

    @Test
    void modify() {
    }

    @Test
    void findUsersByName() {
        User user= new User();

        user.setName("chan");
        user.setPassword("8912");
        user.setUsername("qw");
        user.setPhone("010-45");
        userRepository.save(user);
        System.out.println(userRepository.findByUsername("qw"));
    }

    @Test
    void findUsersByJob() {
        User user= new User();

        user.setName("chan");
        user.setPassword("8912");
        user.setUsername("qw");
        user.setPhone("010-45");
        userRepository.save(user);
        System.out.println(userRepository.findByUsername("qw"));
    }

    @Test
    void findUserByUsername() {
    }

    @Test
    void login() {
    }
}