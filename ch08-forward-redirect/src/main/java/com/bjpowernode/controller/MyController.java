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
    @RequestMapping(value = "/doForward.do")
    public ModelAndView doForward() {
        //使用doSome方法处理some.do请求
        ModelAndView modelAndView = new ModelAndView();
        //添加数据，springmvc框架在请求的最后把数据放入到request作用域
        modelAndView.addObject("msg", "欢迎使用springmvc开发WEB项目");
        modelAndView.addObject("fun", "执行doSome（）");

        //显示转发
//        modelAndView.setViewName("forward:/WEB-INF/view/subview/show.jsp");
        modelAndView.setViewName("forward:/fuck.jsp");
        return modelAndView;
    }

    /**
     * 控制器方法返回ModelAndView实现Redirect[重定向]
     * 语法： modelAndView.setViewName("redirect：完整的jsp路径");
     * 特点：不和视图解析器一同使用，就当项目中没有视图解析器
     * 1.框架对重定向的操作将模型中简单类型的数据转化为字符串使用，作为fuck.jsp的get请求参数使用
     * 目的是在doRedirect.do和fuck.jsp传递数据
     * 2.在目标fuck.jsp页面可以使用参数集合对象${param.myname}获取请求参数值
     * 3.重定向不能访问 /web-inf资源
     */
    @RequestMapping(value = "/doRedirect.do")
    public ModelAndView doRedirect(String name, Integer age) {
        //使用doSome方法处理some.do请求
        ModelAndView modelAndView = new ModelAndView();
        //添加数据，springmvc框架在请求的最后把数据放入到request作用域
        modelAndView.addObject("myname", name);
        modelAndView.addObject("myage", age);
        //重定向不能访问 /web-inf资源
        //modelAndView.setViewName("redirect:/WEB-INF/view/subview/show.jsp");
        //重定向
        modelAndView.setViewName("redirect:/fuck.jsp");
        return modelAndView;
    }
}

