package com.bjpowernode.dao;

import com.bjpowernode.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findUserById(int id);

    void updateUser(User user);

    void userDelete(int id);

    void add(User user);
}
