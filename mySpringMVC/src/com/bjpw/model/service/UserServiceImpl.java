package com.bjpw.model.service;

import com.bjpw.entity.Users;
import com.bjpw.model.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.model.service
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/15 16:45
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersDao usersDao;

    @Override
    public Users getByUserNameAndPwd(String username, String password) {
        return usersDao.selectByUserNameAndPwd(username,password);
    }
}
