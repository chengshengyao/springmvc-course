package com.bjpowernode.service;

import com.bjpowernode.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findUserById(int id);
    void updateUser(User user);
    void deleteUser(int id);
    void add(User user);
}
