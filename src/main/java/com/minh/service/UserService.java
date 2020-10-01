package com.minh.service;


import com.minh.model.MyUser;

import java.util.List;

public interface UserService {
    List<MyUser> findAll();

    MyUser findById(Long id);

    void save(MyUser user);

    void remove(Long id);
}
