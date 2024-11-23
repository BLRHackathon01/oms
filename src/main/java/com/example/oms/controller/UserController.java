package com.example.oms.controller;


import com.example.oms.domain.User;
import com.example.oms.model.RestResponse;
import com.example.oms.service.UserService;
import com.example.oms.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User  createUser(@RequestBody User usr) {
        usr = userService.saveUser(usr);
        return usr;
    }

    @GetMapping(value = "/list")
    public List<User> getusers()
    {
        List<User> users = userService.findAll();
        return users;
    }
}
