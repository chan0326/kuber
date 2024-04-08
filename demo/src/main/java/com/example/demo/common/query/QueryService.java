package com.example.demo.common.query;

import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.component.PageRequestVo;
import org.springframework.data.domain.Example;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface QueryService<T>{
      List<T> findAll( );
      Optional<T> findById(Long id);
      Long count();
      boolean existsById(Long id);
}
