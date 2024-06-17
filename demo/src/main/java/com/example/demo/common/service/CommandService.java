package com.example.demo.common.service;


import com.example.demo.common.component.MessengerVo;

public interface CommandService<T> {
    MessengerVo save(T t);
    MessengerVo deleteById(Long id);
    MessengerVo modify(T t);
}
