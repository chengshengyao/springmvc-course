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
 * 次注解是创建处理器对象，放置于springmvc容器中
 * 可处理请求的都是控制器，也叫后端控制器【back controller】
 */
@Controller
public class MyController {
    //处理用户提交的请求，springmvc中使用自定义方法处理，可以有多种返回值，多种参数。
    //RequestMapping注解：请求映射，作用是将请求地址与请求处理方法【控制器方法】相绑定 类doGet/doPost
    //注解属性 value String类型 表示请求url 值唯一
    //返回值 ModelAndView 本次请求处理的结果
    @RequestMapping(value = {"/some.do","/first.do"})
    public ModelAndView doSome() {
        //使用doSome方法处理some.do请求
        ModelAndView modelAndView = new ModelAndView();
        //添加数据，springmvc框架在请求的最后把数据放入到request作用域
        modelAndView.addObject("msg", "欢迎使用springmvc开发WEB项目");
        modelAndView.addObject("fun", "执行doSome（）");
        //指定视图，指定视图的完整路径
        //springmvc框架对视图执行forward操作
        //modelAndView.setViewName("/WEB-INF/view/subview/show.jsp");
        //配置内部资源视图分解器后，可以使用逻辑名称（文件名），设置视图名
        //springmvc框架会使用 前缀+逻辑名称+后缀 组成完整路径
        modelAndView.setViewName("show");
        return modelAndView;
    }
    @RequestMapping(value = {"/other.do","/second.do"})
    public ModelAndView doOther() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "O(∩_∩)O欢迎使用springmvc开发WEB项目");
        modelAndView.addObject("fun", "O(∩_∩)O执行doOther（）");
        modelAndView.setViewName("other");
        return modelAndView;
    }
}
