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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


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
     * 处理器方法返回String--表示逻辑视图名称，需要配置视图解析器
     */
    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(HttpServletRequest httpServletRequest,
                               String name,
                               Integer age) {
        System.out.println("doReturnView:name" + name + "age" + age);
        //自己手工添加数据至request作用域
        httpServletRequest.setAttribute("myname", name);
        httpServletRequest.setAttribute("myage", age);
        //"show"表示视图名称，项目中配置视图解析器
        //框架对视图执行forward操作
        return "show";
    }

    /**
     * 处理器方法返回String--表示逻辑视图名称，不配置视图解析器
     */
    @RequestMapping(value = "/returnString-view2.do")
    public String doReturnView2(HttpServletRequest httpServletRequest,
                                String name, Integer age) {
        System.out.println("doReturnView2:name" + name + "age" + age);
        //自己手工添加数据至request作用域
        httpServletRequest.setAttribute("myname", name);
        httpServletRequest.setAttribute("myage", age);
        //"show"表示视图名称，项目中配置视图解析器
        //框架对视图执行forward操作
        return "\\WEB-INF\\view\\subview\\show.jsp";
    }

    /**
     * 处理器方法返回Void响应ajax请求
     */
    @RequestMapping(value = "/returnVoid-ajax.do")
    public void doReturnVoid(HttpServletResponse httpServletResponse
            , String name
            , Integer age
    ) {
        System.out.println("doReturnView3:name" + name + "age" + age);
        //处理ajax，使用json数据格式
        //service调用完成了，使用student表示处理数据
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        //把结果的数据格式转为json格式
        if (student != null) {
            //ObjectMapper om= new ObjectMapper();
        }
    }

    /**
     * 处理器方法返回一个Student对象，通过框架转换为json格式，响应ajax请求
     * 将处理器方法返回的对象，转为json，通过响应对象输出至浏览器
     * 返回对象框架处理流程：
     * 1.框架将返回值对象类型，调用【HttpMessageConverter】的实现类，canWrite()进行判断可否转化
     * 2.调用框架中的write()，完成数据格式类型的转化
     * 3.框架进行调用@ResponseBody注解中的方法将结果数据输出至浏览器
     */
    @ResponseBody
    @RequestMapping(value = "/returnStudentJson.do")
    public Student doStudentJsonObject(String name, Integer age) {
        //调用service，获取Student对象表示处理结果
        Student student = new Student();
        student.setName("烦死了");
        student.setAge(80);
        return student;//此对象将被框架转化为json数据格式
    }

    /**
     * 处理器方法返回一个对象集合
     */
    @ResponseBody
    @RequestMapping(value = "/returnStudentJsonArray.do")
    public List<Student> doStudentJsonObjectArray(String name, Integer age) {
        ArrayList<Student> students = new ArrayList<>();
        //调用service，获取Student对象表示处理结果
        Student student = new Student();
        student.setName("烦死了");
        student.setAge(80);
        student = new Student();
        student.setName("司马玩意");
        student.setAge(88);
        students.add(student);
        return students;//此对象将被框架转化为json数据格式
    }

    /**
     * 处理器方法返回一个String，表示数据而不是视图。
     * 区分返回值字符串是数据还是视图，看有无  @ResponseBody 【有就是String】
     * , produces = "text/plain;charset=默认是8859-1"
     */
    @ResponseBody
    @RequestMapping(value = "/returnStringDate.do"
             , produces = "text/plain;charset=utf-8")
    public String doStringData(String name, Integer age) {

        return "你爹是数据";//此对象将被框架转化为json数据格式
    }
}
