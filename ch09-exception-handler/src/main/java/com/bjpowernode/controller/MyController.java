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

import com.bjpowernode.exception.AgeException;
import com.bjpowernode.exception.MyException;
import com.bjpowernode.exception.NameException;
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
    @RequestMapping(value = "/Exception.do")
    public ModelAndView doException(String name, Integer age) throws MyException {
        ModelAndView modelAndView = new ModelAndView();
        //根据请求参数抛出异常
        if (!"zs".equals(name)) {
            throw new NameException("姓名不正确");
        }
        if (age==null||age>80){
            throw new AgeException("年龄比较大");
        }
        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);
        modelAndView.setViewName("show");
        return modelAndView;
    }
}

