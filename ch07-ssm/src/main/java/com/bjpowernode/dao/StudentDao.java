package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

/**
 * @ProjectName: springmvc-course
 * @Package: com.bjpowernode.dao
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/19 14:25
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
