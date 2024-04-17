package com.example.demo.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


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

    @SuppressWarnings("static-access")
    @PostMapping("/save")
    public ResponseEntity<MessengerVo> save(@RequestBody UserDto dto) throws SQLException {
        log.info("입력받은 정보: {}",dto);
        return ResponseEntity.ok(userservice.save(dto));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<MessengerVo> login(@RequestBody UserDto param){
        log.info("입력받은 정보 : {}",param );
        return ResponseEntity.ok(userservice.login(param));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<MessengerVo> deleteById(@RequestParam Long id) throws SQLException {
        log.info("입력받은 정보: {}",id);
        return ResponseEntity.ok(userservice.deleteById(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> findAll() throws SQLException {

        return ResponseEntity.ok(userservice.findAll());
    }
    @GetMapping("/detail")
    public ResponseEntity<Optional<UserDto>> findById(@RequestParam Long id) throws SQLException {

        return ResponseEntity.ok((userservice.findById(id)));
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count() throws SQLException {

        return ResponseEntity.ok(userservice.count());
    }

    @PutMapping("/modify")
    public ResponseEntity<MessengerVo> modify(@RequestBody UserDto param) {
        log.info("입력받은 정보 : {}", param );
        return ResponseEntity.ok(userservice.modify(param));
    }

    @PostMapping("/search")
    public ResponseEntity<List<UserDto>> findUsersByName(@RequestBody UserDto param) {
        //log.info("입력받은 정보 : {}", name );
        return ResponseEntity.ok(userservice.findUsersByName(param.getName()));
    }



}



