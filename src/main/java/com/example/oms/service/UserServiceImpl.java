package com.example.oms.service;

import com.example.oms.domain.User;
import com.example.oms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user) {

        user = userRepository.save(user);

        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> usr = null;

        if (userRepository !=null) usr = userRepository.findAll();
        if(usr==null || usr.size()==0) usr = new ArrayList<>();
        return usr;
    }
}
