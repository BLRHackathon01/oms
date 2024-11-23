package com.example.oms.controller;

import com.example.oms.dao.UserRequestDto;
import com.example.oms.dao.UserResponseDto;
import com.example.oms.dto.User;
import com.example.oms.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oms")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){

        User user = userService.createUser(userRequestDto.getName(),
                userRequestDto.getEmail(),
                userRequestDto.getPassword());

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setResult("User created Successfully with UserId : " + user.getId());

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);

    }
}
