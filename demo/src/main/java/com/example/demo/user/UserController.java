package com.example.demo.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


import com.example.demo.common.component.MessengerVo;
import com.example.demo.user.domain.UserDto;
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





}



