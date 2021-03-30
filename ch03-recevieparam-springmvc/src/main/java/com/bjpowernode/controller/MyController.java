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

import com.bjpowernode.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
    /**
     *逐个接收请求参数：
     * 要求：控制器方法的形参名和请求中的参数名必须一致
     * 同名的请求参数赋值给同名的形参
     * 框架接收请求参数
     * 1.使用request对象接收请求参数
     * 2.框架通过中央调度器调用MyController的doFirst方法时。
     *   按名称对应，把接收的参数赋值给形参【框架提供类型转换的功能】
     * 400状态码是客户端错误，表示提交请求过程中发生问题
     */
    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView doFirst(String name,Integer age) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myname", name);
        modelAndView.addObject("myage", age);
        modelAndView.setViewName("show");
        return modelAndView;
    }

    /**
     *提交参数时参数名，和处理器方法的形参名不一样【逐个接收】
     * 使用【注解RequestParam】解决此问题
     * 属性 value 请求中参数名
     * 属性 required 默认true 表示请求中必须包含此参数 false 表示请求中不必须包含此参数
     * 位置：处理器方法形参参数前
     */
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView doReceiveParam
    (@RequestParam(value = "rname",required = false) String name
            ,@RequestParam(value = "rage",required = false) Integer age) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myname", name);
        modelAndView.addObject("myage", age);
        modelAndView.setViewName("show");
        return modelAndView;
    }

    /**
     *处理器方法形参是java对象，此对象中的属性名与请求参数名一致
     * springMVC框架会创建java对象，给属性赋值。
     */
    @RequestMapping(value = "/receiveobject.do")
    public ModelAndView doReceiveObject(Student student) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myname",student.getName() );
        modelAndView.addObject("myage", student.getAge());
        modelAndView.setViewName("show");
        return modelAndView;

    }
}
