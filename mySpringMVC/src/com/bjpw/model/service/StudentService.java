package com.bjpw.model.service;

import com.bjpw.entity.Student;
import com.bjpw.util.PageBean;

import java.util.List;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.model.service
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/12 20:18
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface StudentService {
    /**
     * 查询所有学生信息的方法
     * @return
     */
    List<Student> list();

    /**
     * 分页查询的方法
     * @param pageBean 包含了分页查询时用到的参数
     * @return
     */
    List<Student> list(PageBean pageBean);
    /**
     * 查询一个学生信息的方法
     * @param stuId 学生的编号
     * @return
     */
    Student get(int stuId);

    /**
     * 添加学生的方法
     * @param student 要添加的学生对象
     * @return
     */
    int save(Student student);

    /**
     * 更新学生信息的方法
     * @param student 要更新的学生对象
     * @return
     */
    int update(Student student);

    /**
     * 删除学生信息的方法
     * @param stuId 要删除学生的编号
     * @return
     */
    int delete(int stuId);
}
