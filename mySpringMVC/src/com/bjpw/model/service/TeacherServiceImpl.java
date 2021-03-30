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
 * @Description: java����������
 * @Author: ������
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
     * ��ѯ���еĽ�ʦ��Ϣ
     * @return
     */
    @Override
    public List<Teacher> list() {
        return teacherDao.selectAll();
    }

    /**
     * ��������ѯ��ʦ��Ϣ�ķ���
     * @param teacher
     * @return
     */
    @Override
    public List<Teacher> list(Teacher teacher) {
        return teacherDao.selectByTeacher(teacher);
    }

    /**
     * ��ҳ�ķ���
     * @param pageBean �����˷�ҳ��ѯ���õ��Ĳ���
     * @return
     */
    @Override
    public List<Teacher> list(PageBean pageBean) {

        //��ѯ�ܼ�¼��
        int count = teacherDao.selectTotalCount();
        pageBean.setTotalCount(count);
        return teacherDao.selectByPage(pageBean);
    }

    /**
     * ��ҳ�Ͳ�ѯ���ϵķ���
     * @param teacher ������Ҫ��ѯ��ʦ������
     * @param pageBean �����˷�ҳ��ѯ���õ��Ĳ���
     * @return
     */
    @Override
    public List<Teacher> list(Teacher teacher, PageBean pageBean) {
        //��ѯ�ܼ�¼��
        int count = teacherDao.searchTotalCount(teacher);
        pageBean.setTotalCount(count);
        return teacherDao.searchByPage(teacher,pageBean);
    }

    /**
     * ��ѯһ����ʦ����Ϣ
     * @param teaId ��ʦ�ı��
     * @return
     */
    @Override
    public Teacher get(int teaId) {
        return teacherDao.selectByPrimaryKey(teaId);
    }

    /**
     * ��ӽ�ʦ��Ϣ
     * @param teacher Ҫ��ӵĽ�ʦ����
     * @return
     */
    @Override
    public int save(Teacher teacher) {
        return teacherDao.insertSelective(teacher);
    }

    /**
     * ���½�ʦ��Ϣ
     * @param teacher Ҫ���µĽ�ʦ����
     * @return
     */
    @Override
    public int update(Teacher teacher) {
        return teacherDao.updateByPrimaryKeySelective(teacher);
    }

    /**
     * ɾ����ʦ��Ϣ
     * @param teaId Ҫɾ���Ľ�ʦ��Ӧ�ı��
     * @return
     */
    @Override
    public int delete(int teaId) {
        //ִ�и��ģ����Ĵ˽�ʦ��ѧ����tea_id��ֵΪnull
        //update t_student set tea_id=null where tea_id=#{teaId}
        //studentDao.updateStuSetTeaNull(stuId);
        return teacherDao.deleteByPrimaryKey(teaId);
    }

    /**
     * ����ɾ���ķ���
     * @param teaIds ����ɾ��ʱ����Ӧ��ż��ϵ�����
     * @return
     */
    @Override
    public int delete(Integer[] teaIds) {
        return teacherDao.deleteBeath(teaIds);
    }
}
