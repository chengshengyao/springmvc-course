package com.bjpw.controller;

import com.bjpw.entity.Users;
import com.bjpw.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.controller
 * @Description: java����������
 * @Author: ������
 * @CreateDate: 2020/12/15 16:47
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("login")
    void login(){

    }

    @RequestMapping("saveLogin")
    String saveLogin(Users users, HttpSession session){
        Users userDB = userService.getByUserNameAndPwd(users.getUsername(), users.getPassword());
        if (userDB == null) {
            //��¼ʧ��
            users.setMsg("�Բ��𣬵�¼ʧ�ܣ������û����������Ƿ���ȷ��");
            return "login";
        }
        //��¼�ɹ�
        session.setAttribute("LOGIN_USER",userDB);
        return "redirect:/";
    }

    @RequestMapping("logout")
    String logout(HttpSession session){
        session.removeAttribute("LOGIN_USER");
        return "redirect:/";
    }
}
