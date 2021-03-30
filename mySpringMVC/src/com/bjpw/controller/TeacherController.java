package com.bjpw.controller;

import com.bjpw.entity.Teacher;
import com.bjpw.model.service.TeacherService;
import com.bjpw.util.PageBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.controller
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/13 0:46
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping("list")
    List<Teacher> list(Teacher teacher, PageBean pageBean){
        //return teacherService.list();
        // return teacherService.list(teacher);
        //return teacherService.list(pageBean);
        return teacherService.list(teacher,pageBean);
    }

    @RequestMapping("edit")
    void edit(Teacher teacher,Integer teaId){
        if (teaId != null) {//当教师编号不为空时，就证明此时是从修改进入的

            Teacher teacherDB = teacherService.get(teaId);
            BeanUtils.copyProperties(teacherDB,teacher);
        }
    }
    @RequestMapping("save")
    String save(Teacher teacher){
        //添加和修改的入口都是edit，添加没有提交教师编号，修改操作提交了教师编号,他们都将结果提交到出口
        //save就是添加和修改的出口，在这里可以先获取教师编号，判断教师编号是否为空
        //如果教师编号为空，则说明在入口的时候没有提交教师编号，此时就是添加操作，那就执行添加的方法
        //如果教师编号不为空，则说明在入口的时候提交了教师编号，此时就是修改操作，那就执行修改的方法
        if (teacher.getTeaId() != null) {
            //执行修改
            teacherService.update(teacher);
        }else {
            //执行添加
            teacherService.save(teacher);
        }
        return "redirect:list";
    }
    @RequestMapping("delete")
    String delete(int teaId){
        teacherService.delete(teaId);
        return "redirect:list";
    }
    @RequestMapping("deleteBeath")
    String deleteBeath(Integer[] teaIds){
        teacherService.delete(teaIds);
        return "redirect:list";
    }

}
