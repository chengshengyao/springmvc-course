package com.bjpw.model.service;

import com.bjpw.entity.Users;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.model.service
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/15 16:44
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface UserService {

    Users getByUserNameAndPwd( String username, String password);
}
