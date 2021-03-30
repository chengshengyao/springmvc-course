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
 * @Description: java����������
 * @Author: ������
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
     * ��ѯ����ѧ����Ϣ�ķ���
     * @return
     */
    @Override
    public List<Student> list() {
        return studentDao.selectAll();
    }

    @Override
    public List<Student> list(PageBean pageBean) {
        //���ò�ѯ�ܼ�¼���ķ���
        int count = studentDao.selectcount();
        pageBean.setTotalCount(count);
        return studentDao.selectByPager(pageBean);
    }

    /**
     * ��ѯһ��ѧ����Ϣ�ķ���
     * @param stuId ѧ���ı��
     * @return
     */
    @Override
    public Student get(int stuId) {
        return studentDao.selectByPrimaryKey(stuId);
    }

    /**
     * ���ѧ����Ϣ�ķ���
     * @param student Ҫ��ӵ�ѧ������
     * @return
     */
    @Override
    public int save(Student student) {
        return studentDao.insert(student);
    }

    /**
     * ����ѧ����Ϣ�ķ���
     * @param student Ҫ���µ�ѧ������
     * @return
     */
    @Override
    public int update(Student student) {
        return studentDao.updateByPrimaryKey(student);
    }

    /**
     * ɾ��ѧ����Ϣ�ķ���
     * @param stuId Ҫɾ��ѧ���ı��
     * @return
     */
    @Override
    public int delete(int stuId) {
        return studentDao.deleteByPrimaryKey(stuId);
    }
}
