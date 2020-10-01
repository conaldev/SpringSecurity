package com.minh.service.impl;

import com.minh.model.MyUser;
import com.minh.repository.UserRepository;
import com.minh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<MyUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public MyUser findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(MyUser user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.remove(id);
    }
}
