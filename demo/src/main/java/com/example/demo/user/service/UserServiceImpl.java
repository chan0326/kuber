package com.example.demo.user.service;


import com.example.demo.common.component.JwtProvider;
import com.example.demo.common.component.MessengerVo;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public MessengerVo save(UserDto userDto) {
//        entityToDto((userRepository.save(dtoToEntity(userDto))));
        return MessengerVo.builder()
                .message(
                        Stream.of(userDto)
                                .filter(i -> !userRepository.existsByUsername(userDto.getUsername()))
                                .peek(i -> userRepository.save(dtoToEntity(i)))
                                .map(i -> "SUCCESS")
                                .findAny()
                                .orElseGet(() -> "FAILURE")
                )
                .build();
    }

    @Override
    public MessengerVo deleteById(Long id) {
        log.info(id);
        return MessengerVo.builder()
                .message(
                        Stream.of(id)
                                .filter(i->userRepository.existsById(i))
                                .peek(i->userRepository.deleteById(i))
                                .map(i->"SUCCESS")
                                .findAny()
                                .orElseGet(()->"FAILURE")
                )
                .build();

    }



    @Override
    public List<UserDto> findAll() {
//        List<User> userList = userRepository.findAll();
//        List<UserDto> list = new ArrayList<>();
//        for (User user: userList){
//            list.add(entityToDto(user));
//        }
//        userList.forEach(i -> list.add(entityToDto(i)));
//        return  list;
       return    userRepository.findAll().stream().map(i -> entityToDto(i)).toList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {

        return userRepository.findById(id).map(i -> entityToDto(i));
    }

    @Override
    public Long count() {
        return userRepository.count();
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public MessengerVo modify(UserDto user) {
         Optional<User> userList=userRepository.findById(user.getId());
         return MessengerVo.builder().message(
                 userRepository.findById(user.getId()).stream()
                         .peek(i->i.setName(user.getName() == null?userList.get().getName(): user.getName()))
                         .peek(i->i.setPassword(user.getPassword() == null?userList.get().getPassword():user.getPassword()))
                         .peek(i->i.setUsername(user.getUsername() == null?userList.get().getUsername():user.getUsername()))
                         .peek(i->i.setPhone(user.getPhone()== null?userList.get().getPhone():user.getPhone()))
                         .peek(i->i.setJob(user.getJob() == null?userList.get().getJob():user.getJob()))
                         .map(i->userRepository.save(i))
                         .map(i->"SUCCESS")
                         .findAny()
                         .orElseGet(()->"FAIL"))
         .build();
    }

    @Override
    public List<UserDto> findUsersByName(String name) {
       return userRepository.findByName(name).stream().map(i->entityToDto(i)).toList();
    }

    @Override
    public List<UserDto> findUsersByJob(String job) {
        return userRepository.findByJob(job).stream().map(i->entityToDto(i)).toList();
    }


    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
// SRP 에 따라 아이디 존재여부를 프론트에서 먼저 판단하고, 넘어옴 (시큐리티) get()-> optional 때문에 아이디가 무조건존재한다는 뜻으로 사용 저걸 안쓰면  or else()
    @Override
    public MessengerVo login(UserDto param) {
        boolean flag = findUserByUsername(param.getUsername()).get().getPassword().equals( param.getPassword());
        return MessengerVo.builder()
                .message( flag ? "SUCCESS":"FAILRE")
                .token(flag ? jwtProvider.createToken(param): "none")
                .build();
    }





}
