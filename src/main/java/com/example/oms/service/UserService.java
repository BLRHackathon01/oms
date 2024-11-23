package com.example.oms.service;

import com.example.oms.domain.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    List<User> findAll();
}
