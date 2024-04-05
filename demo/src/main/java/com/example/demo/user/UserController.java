package com.example.demo.user;

import java.sql.SQLException;


import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.component.PageRequestVo;
import com.example.demo.user.model.UserDto;
import com.example.demo.user.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RestController  //controller + ResponseBody
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserServiceImpl userservice;

    @SuppressWarnings("unchecked")
    @PostMapping("")
    public ResponseEntity<MessengerVo> save(UserDto dto) throws SQLException {
        userservice.save(dto);
        return ResponseEntity.ok(new MessengerVo());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessengerVo> deleteById(Long id) throws SQLException {
        userservice.deleteById(id);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("")
    public ResponseEntity<MessengerVo> findAll(PageRequestVo vo) throws SQLException {
        userservice.findAll(null);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MessengerVo> findById(Long id) throws SQLException {
        userservice.findById(id);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/count")
    public ResponseEntity<MessengerVo> count() throws SQLException {
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<MessengerVo> existsById(Long id) throws SQLException {
        userservice.existsById(id);
        return ResponseEntity.ok(new MessengerVo());
    }



}



