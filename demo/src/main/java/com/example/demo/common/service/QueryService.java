package com.example.demo.common.service;


import com.example.demo.common.component.MessengerVo;

import java.util.List;
import java.util.Optional;

public interface QueryService <T>{
    List<T> findAll();
    Optional<T> findById(Long id);
    MessengerVo count();
    Boolean existsById(Long id);
}
