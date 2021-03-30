package com.bjpowernode.controller;

/**
 * @ProjectName: springmvc-course
 * @Package: com.bjpowernode
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/16 11:28
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {
    /**
     * 控制器方法返回ModelAndView实现forward[请求转发]
     * 语法： modelAndView.setViewName("forward：完整的jsp路径");
     * 特点：不和视图解析器一同使用，就当项目中没有视图解析器
     */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age)  {
        System.out.println("）））））））））此时执行了MyController的doSome方法（（（（（（（（（");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);
        modelAndView.setViewName("show");
        return modelAndView;
    }
}

