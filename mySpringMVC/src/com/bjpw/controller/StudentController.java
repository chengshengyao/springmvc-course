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
 * @Description: java����������
 * @Author: ������
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
     * ��ѯ���е�ѧ����Ϣ
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
        //����֮ǰ�������ݵĻ��ԣ�����Ҫ�޸ĵ�ѧ����ţ��Ȳ�ѯ����ѧ������Ϣ���л���
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
