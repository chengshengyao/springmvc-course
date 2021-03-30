package com.bjpowernode.handler;

import com.bjpowernode.exception.AgeException;
import com.bjpowernode.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName: springmvc-course
 * @Package: com.bjpowernode.handler
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/20 17:52
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */

/**
 * 控制器类增加功能：异常处理功能
 * 使框架知道 此注解所在的包名，顾在springmvc的配置文件中声明 元件扫描器
 * 指定此注解所在的包名
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //定义方法处理产生的异常
    //处理异常的方法和控制器方法一样
    @ExceptionHandler(value = NameException.class)//表示异常的类型，发生异常以此方法处理
    public ModelAndView doNameException(Exception exception){//形参表示控制器中抛出的异常对象，获取异常信息
        //处理NameException
        //异常处理逻辑1.记录异常信息至日志文件或数据库 2.发送通知把异常信息通过邮件微信发送至相关人员3.给用户友好的提示
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","姓名必须是zs，其他用户不能访问");
        modelAndView.addObject("ex",exception);
        modelAndView.setViewName("nameError");
        return modelAndView;
    }
    @ExceptionHandler(value = AgeException.class)//表示异常的类型，发生异常以此方法处理
    public ModelAndView doAgeException(Exception exception){//形参表示控制器中抛出的异常对象，获取异常信息
        //处理AgeException
        //异常处理逻辑1.记录异常信息至日志文件或数据库 2.发送通知把异常信息通过邮件微信发送至相关人员3.给用户友好的提示
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","您的年龄过大");
        modelAndView.addObject("ex",exception);
        modelAndView.setViewName("ageError");
        return modelAndView;
    }
    //处理其他异常【判读以外，不知名的】
    @ExceptionHandler//只能存在一个 处理其他异常的方法
    public ModelAndView doOtherException(Exception exception){//形参表示控制器中抛出的异常对象，获取异常信息
        //处理AgeException
        //异常处理逻辑1.记录异常信息至日志文件或数据库 2.发送通知把异常信息通过邮件微信发送至相关人员3.给用户友好的提示
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","其他异常【判读以外，不知名的】");
        modelAndView.addObject("ex",exception);
        modelAndView.setViewName("defaultError");
        return modelAndView;
    }
}
