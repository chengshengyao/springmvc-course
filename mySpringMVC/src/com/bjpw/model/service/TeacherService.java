package com.bjpw.model.service;

import com.bjpw.entity.Teacher;
import com.bjpw.util.PageBean;

import java.util.List;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.model.service
 * @Description: java����������
 * @Author: ������
 * @CreateDate: 2020/12/13 0:34
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface TeacherService {
    /**
     * ��ѯ���еĽ�ʦ��Ϣ
     * @return
     */
    List<Teacher> list();

    /**
     * ����������ѯ��ʦ��Ϣ�ķ���
     * @param teacher
     * @return
     */
    List<Teacher> list(Teacher teacher);

    /**
     * ��ҳ��ѯ�ķ���
     * @param pageBean �����˷�ҳ��ѯ���õ��Ĳ���
     * @return
     */
    List<Teacher> list(PageBean pageBean);

    /**
     * ����������ѯ�ͷ�ҳ���������Ϸ���
     * @param teacher ������Ҫ��ѯ��ʦ������
     * @param pageBean �����˷�ҳ��ѯ���õ��Ĳ���
     * @return
     */
    List<Teacher> list(Teacher teacher,PageBean pageBean);

    /**
     * ��ѯһ����ʦ����Ϣ
     * @param teaId ��ʦ�ı��
     * @return
     */
    Teacher get(int teaId);

    /**
     * ��ӽ�ʦ��Ϣ
     * @param teacher Ҫ��ӵĽ�ʦ����
     * @return
     */
    int save(Teacher teacher);

    /**
     * ���½�ʦ��Ϣ
     * @param teacher Ҫ���µĽ�ʦ����
     * @return
     */
    int update(Teacher teacher);

    /**
     * ɾ����ʦ��Ϣ
     * @param teaId Ҫɾ���Ľ�ʦ��Ӧ�ı��
     * @return
     */
    int delete(int teaId);

    /**
     * ����ɾ���ķ���
     * @param teaIds ����ɾ��ʱ����Ӧ��ż��ϵ�����
     * @return
     */
    int delete(Integer[] teaIds);

}
