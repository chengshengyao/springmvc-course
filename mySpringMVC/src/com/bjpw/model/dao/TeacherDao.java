package com.bjpw.model.dao;

import com.bjpw.entity.Teacher;
import com.bjpw.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {
    int deleteByPrimaryKey(Integer teaId);

    int deleteBeath(Integer[] teaIds);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teaId);

    List<Teacher> selectAll();

    List<Teacher> selectByPage(PageBean pageBean);

    int  selectTotalCount();

    List<Teacher> searchByPage(@Param("teacher") Teacher teacher, @Param("pageBean") PageBean pageBean);

    int  searchTotalCount(@Param("teacher") Teacher teacher);

    List<Teacher> selectByTeacher(Teacher teacher);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}