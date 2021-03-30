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


/**
 * RequestMapping:
 * value:所有请求地址的公共部分
 * 位置：位于类的上面
 */
//@RequestMapping(value = "/test")

/**
 * 次注解是创建处理器对象，放置于springmvc容器中
 * 可处理请求的都是控制器，也叫后端控制器【back controller】
 */
@Controller
public class MyController {
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age) {
        System.out.println("doSome:name" + name + "age" + age);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myname",name);
        modelAndView.addObject("myage",age);
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
