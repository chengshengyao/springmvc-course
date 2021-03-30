package com.bjpw.model.service;

import com.bjpw.entity.Student;
import com.bjpw.util.PageBean;

import java.util.List;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.model.service
 * @Description: java����������
 * @Author: ������
 * @CreateDate: 2020/12/12 20:18
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface StudentService {
    /**
     * ��ѯ����ѧ����Ϣ�ķ���
     * @return
     */
    List<Student> list();

    /**
     * ��ҳ��ѯ�ķ���
     * @param pageBean �����˷�ҳ��ѯʱ�õ��Ĳ���
     * @return
     */
    List<Student> list(PageBean pageBean);
    /**
     * ��ѯһ��ѧ����Ϣ�ķ���
     * @param stuId ѧ���ı��
     * @return
     */
    Student get(int stuId);

    /**
     * ���ѧ���ķ���
     * @param student Ҫ��ӵ�ѧ������
     * @return
     */
    int save(Student student);

    /**
     * ����ѧ����Ϣ�ķ���
     * @param student Ҫ���µ�ѧ������
     * @return
     */
    int update(Student student);

    /**
     * ɾ��ѧ����Ϣ�ķ���
     * @param stuId Ҫɾ��ѧ���ı��
     * @return
     */
    int delete(int stuId);
}
