package com.example.demo.common.command;

public interface CommandService<T>{
      T save(T t);
      void deleteById(Long id);
}
