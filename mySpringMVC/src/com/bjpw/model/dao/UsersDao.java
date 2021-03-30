package com.bjpw.model.dao;

import com.bjpw.entity.Users;
import org.apache.ibatis.annotations.Param;

public interface UsersDao {
    int deleteByPrimaryKey(Integer userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userid);

    Users selectByUserNameAndPwd(@Param("username") String username, @Param("password") String password);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}