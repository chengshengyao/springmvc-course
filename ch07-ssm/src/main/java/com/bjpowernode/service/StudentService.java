package com.bjpowernode.service;

import com.bjpowernode.domain.Student;

import java.util.List;

/**
 * @ProjectName: springmvc-course
 * @Package: com.bjpowernode.service
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/19 14:36
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
public interface StudentService {
    int addStudent(Student student);
    List<Student> queryStudents();
}
