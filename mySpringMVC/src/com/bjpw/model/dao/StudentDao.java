package com.bjpw.model.dao;

import com.bjpw.entity.Student;
import com.bjpw.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    int deleteByPrimaryKey(Integer stuId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuId);

    List<Student> selectAll();

    /**
     * 分页的方法
     * @param pageBean 分页对象，包含了分页过程中所用到的参数
     * @return
     */
    //List<Student> selectByPager(@Param("no") int no, @Param("pageNo") int pageNo);
    List<Student> selectByPager(PageBean pageBean);

    int selectcount();

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int updateStuSetTeaNull(Integer teaId);
}