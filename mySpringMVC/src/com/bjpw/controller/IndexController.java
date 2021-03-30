package com.bjpw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.controller
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/15 16:49
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class IndexController {

    @RequestMapping("index")
    ModelAndView login(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new InternalResourceView("/welcome.jsp"));
        return modelAndView;
    }
}
