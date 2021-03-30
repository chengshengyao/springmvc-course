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
 * @Description: java����������
 * @Author: ������
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
        if (teaId != null) {//����ʦ��Ų�Ϊ��ʱ����֤����ʱ�Ǵ��޸Ľ����

            Teacher teacherDB = teacherService.get(teaId);
            BeanUtils.copyProperties(teacherDB,teacher);
        }
    }
    @RequestMapping("save")
    String save(Teacher teacher){
        //��Ӻ��޸ĵ���ڶ���edit�����û���ύ��ʦ��ţ��޸Ĳ����ύ�˽�ʦ���,���Ƕ�������ύ������
        //save������Ӻ��޸ĵĳ��ڣ�����������Ȼ�ȡ��ʦ��ţ��жϽ�ʦ����Ƿ�Ϊ��
        //�����ʦ���Ϊ�գ���˵������ڵ�ʱ��û���ύ��ʦ��ţ���ʱ������Ӳ������Ǿ�ִ����ӵķ���
        //�����ʦ��Ų�Ϊ�գ���˵������ڵ�ʱ���ύ�˽�ʦ��ţ���ʱ�����޸Ĳ������Ǿ�ִ���޸ĵķ���
        if (teacher.getTeaId() != null) {
            //ִ���޸�
            teacherService.update(teacher);
        }else {
            //ִ�����
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
