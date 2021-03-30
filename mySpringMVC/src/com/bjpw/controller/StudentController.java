package com.bjpw.controller;

import com.bjpw.entity.Student;
import com.bjpw.entity.Teacher;
import com.bjpw.model.service.StudentService;
import com.bjpw.model.service.TeacherService;
import com.bjpw.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.controller
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/12 20:29
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
@RequestMapping("student")
public class StudentController {


    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    /**
     * 查询所有的学生信息
     * @return
     */
    @RequestMapping("list")
    List<Student> list(PageBean pageBean){
        //return studentService.list();
        return studentService.list(pageBean);
    }

    @RequestMapping("add")
    List<Teacher> add(){
        return teacherService.list();
    }

    @RequestMapping("save")
   String save(Student student){
        studentService.save(student);
        return "redirect:list";
    }
    @RequestMapping("edit")
    Student edit(ArrayList<Teacher> list,int stuId){

       list.addAll(teacherService.list());
        //更新之前先做数据的回显，根据要修改的学生编号，先查询出该学生的信息进行回显
        return studentService.get(stuId);
    }

    @RequestMapping("saveUpdate")
    String updateStu(Student student){
        studentService.update(student);
        return "redirect:list";
    }

    @RequestMapping("del")
    String del(int stuId){
        studentService.delete(stuId);
        return "redirect:list";
    }
}
