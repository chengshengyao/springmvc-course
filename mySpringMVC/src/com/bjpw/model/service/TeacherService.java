package com.bjpw.model.service;

import com.bjpw.entity.Teacher;
import com.bjpw.util.PageBean;

import java.util.List;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.model.service
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/13 0:34
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface TeacherService {
    /**
     * 查询所有的教师信息
     * @return
     */
    List<Teacher> list();

    /**
     * 根据条件查询教师信息的方法
     * @param teacher
     * @return
     */
    List<Teacher> list(Teacher teacher);

    /**
     * 分页查询的方法
     * @param pageBean 包含了分页查询所用到的参数
     * @return
     */
    List<Teacher> list(PageBean pageBean);

    /**
     * 根据条件查询和分页搜索的整合方法
     * @param teacher 包含了要查询教师的条件
     * @param pageBean 包含了分页查询所用到的参数
     * @return
     */
    List<Teacher> list(Teacher teacher,PageBean pageBean);

    /**
     * 查询一个教师的信息
     * @param teaId 教师的编号
     * @return
     */
    Teacher get(int teaId);

    /**
     * 添加教师信息
     * @param teacher 要添加的教师对象
     * @return
     */
    int save(Teacher teacher);

    /**
     * 更新教师信息
     * @param teacher 要更新的教师对象
     * @return
     */
    int update(Teacher teacher);

    /**
     * 删除教师信息
     * @param teaId 要删除的教师对应的编号
     * @return
     */
    int delete(int teaId);

    /**
     * 批量删除的方法
     * @param teaIds 批量删除时所对应编号集合的名称
     * @return
     */
    int delete(Integer[] teaIds);

}
