package com.example.oms.service.impl;

import com.example.oms.dto.User;
import com.example.oms.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;


    @Test
    public  void createUserTest(){

        User suhas = userService.createUser("suhas", "suhas@gmail.com", "asb@13");
        Assertions.assertEquals("suhas",suhas.getUserName());
    }

}