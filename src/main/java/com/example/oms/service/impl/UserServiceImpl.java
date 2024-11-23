package com.example.oms.service.impl;

import com.example.oms.dto.User;
import com.example.oms.repository.UserRepository;
import com.example.oms.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String userName,String email,String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        return userRepository.save(user);
    }
}
