package com.bjpw.model.service;

import com.bjpw.entity.Student;
import com.bjpw.model.dao.StudentDao;
import com.bjpw.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.model.service
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/12 20:24
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentDao studentDao;

    /**
     * 查询所有学生信息的方法
     * @return
     */
    @Override
    public List<Student> list() {
        return studentDao.selectAll();
    }

    @Override
    public List<Student> list(PageBean pageBean) {
        //调用查询总记录数的方法
        int count = studentDao.selectcount();
        pageBean.setTotalCount(count);
        return studentDao.selectByPager(pageBean);
    }

    /**
     * 查询一个学生信息的方法
     * @param stuId 学生的编号
     * @return
     */
    @Override
    public Student get(int stuId) {
        return studentDao.selectByPrimaryKey(stuId);
    }

    /**
     * 添加学生信息的方法
     * @param student 要添加的学生对象
     * @return
     */
    @Override
    public int save(Student student) {
        return studentDao.insert(student);
    }

    /**
     * 更新学生信息的方法
     * @param student 要更新的学生对象
     * @return
     */
    @Override
    public int update(Student student) {
        return studentDao.updateByPrimaryKey(student);
    }

    /**
     * 删除学生信息的方法
     * @param stuId 要删除学生的编号
     * @return
     */
    @Override
    public int delete(int stuId) {
        return studentDao.deleteByPrimaryKey(stuId);
    }
}
