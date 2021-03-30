package com.bjpw.model.service;

import com.bjpw.entity.Teacher;
import com.bjpw.model.dao.StudentDao;
import com.bjpw.model.dao.TeacherDao;
import com.bjpw.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.model.service
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/13 0:39
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherDao teacherDao;
    @Autowired
    StudentDao studentDao;

    /**
     * 查询所有的教师信息
     * @return
     */
    @Override
    public List<Teacher> list() {
        return teacherDao.selectAll();
    }

    /**
     * 按条件查询教师信息的方法
     * @param teacher
     * @return
     */
    @Override
    public List<Teacher> list(Teacher teacher) {
        return teacherDao.selectByTeacher(teacher);
    }

    /**
     * 分页的方法
     * @param pageBean 包含了分页查询所用到的参数
     * @return
     */
    @Override
    public List<Teacher> list(PageBean pageBean) {

        //查询总记录数
        int count = teacherDao.selectTotalCount();
        pageBean.setTotalCount(count);
        return teacherDao.selectByPage(pageBean);
    }

    /**
     * 分页和查询整合的方法
     * @param teacher 包含了要查询教师的条件
     * @param pageBean 包含了分页查询所用到的参数
     * @return
     */
    @Override
    public List<Teacher> list(Teacher teacher, PageBean pageBean) {
        //查询总记录数
        int count = teacherDao.searchTotalCount(teacher);
        pageBean.setTotalCount(count);
        return teacherDao.searchByPage(teacher,pageBean);
    }

    /**
     * 查询一个教师的信息
     * @param teaId 教师的编号
     * @return
     */
    @Override
    public Teacher get(int teaId) {
        return teacherDao.selectByPrimaryKey(teaId);
    }

    /**
     * 添加教师信息
     * @param teacher 要添加的教师对象
     * @return
     */
    @Override
    public int save(Teacher teacher) {
        return teacherDao.insertSelective(teacher);
    }

    /**
     * 更新教师信息
     * @param teacher 要更新的教师对象
     * @return
     */
    @Override
    public int update(Teacher teacher) {
        return teacherDao.updateByPrimaryKeySelective(teacher);
    }

    /**
     * 删除教师信息
     * @param teaId 要删除的教师对应的编号
     * @return
     */
    @Override
    public int delete(int teaId) {
        //执行更改，更改此教师的学生的tea_id的值为null
        //update t_student set tea_id=null where tea_id=#{teaId}
        //studentDao.updateStuSetTeaNull(stuId);
        return teacherDao.deleteByPrimaryKey(teaId);
    }

    /**
     * 批量删除的方法
     * @param teaIds 批量删除时所对应编号集合的名称
     * @return
     */
    @Override
    public int delete(Integer[] teaIds) {
        return teacherDao.deleteBeath(teaIds);
    }
}
