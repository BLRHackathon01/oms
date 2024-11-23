package com.example.oms.service;

import com.example.oms.dto.User;

public interface UserService {

    User createUser(String userName,String email,String password);
}
