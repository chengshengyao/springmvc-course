package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: springmvc-course
 * @Package: com.bjpowernode.controller
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/19 14:47
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    //注册学生
    @RequestMapping(value = "/registerStudent.do")
    public ModelAndView registerStudent(Student student) {
        ModelAndView modelAndView = new ModelAndView();
        String message = "注册失败";
        //调用service处理student
        int result = studentService.addStudent(student);
        if (result > 0) {
            //注册成功
            message = "恭喜，学生【 " + student.getName() + " 】注册成功！";
        }
        //添加数据
        modelAndView.addObject("message", message);
        //指定结果页面
        modelAndView.setViewName("resultPage");
        return modelAndView;
    }

    //处理查询，响应异步请求
    @RequestMapping(value = "/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudents() {
    //参数检查，数据处理
        return studentService.queryStudents();
    }
}
