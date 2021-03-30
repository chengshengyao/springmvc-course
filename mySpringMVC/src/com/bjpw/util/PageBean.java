package com.bjpw.util;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;

/**
 * @ProjectName: mySpringMVC
 * @Package: com.bjpw.util
 * @Description: java����������
 * @Author: ������
 * @CreateDate: 2020/12/14 11:20
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class PageBean {
    //��ǰҳ��
    private int currentPage=1;
    //ÿҳ��¼��
    private int pageNo=10;
    //��ʼ�к�(��ʼ��ѯ������)
    private int skipNo=0;
    //�ܼ�¼��
    private int totalCount = 0;
    //��ҳ��
    private int totalPage = 1;
    private String url;
    //�Ƿ�����һҳ
    private boolean hasPrev=false;
    //�Ƿ�����һҳ
    private boolean hasNext=false;

    public PageBean() {

        //���̵߳��л�ȡ����
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        //��ȡ��ǰ�������ַ
        String uri = request.getRequestURI()+"?1=1";
        //������������еĲ�������
        Enumeration<String> parameterNames = request.getParameterNames();
        //����ö�٣��������еĲ�������
        while (parameterNames.hasMoreElements()){
            //ȡ����������
            String paramName = parameterNames.nextElement();
            //ȡ��������������Ӧ��ֵ
            String paramValue = request.getParameter(paramName);
            //���������ֵ��Ϊ�գ���ƴ�ӵ���ǰ�����ַ�Ĳ����б���
            if (paramValue != null && !"".equals(paramValue) && !"1".equals(paramName)&& !"currentPage".equals(paramName)) {
                //�Ե�ַ��������ת��
                try {
                    paramValue = URLEncoder.encode(paramValue,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                uri += "&"+ paramName+"="+paramValue;
            }
        }
        //Ϊurl���Ը�ֵ
        url = uri;
    }

    //���¼��㿪ʼ��ѯ�������ķ���
    public void reCountSkipNo(){
        //��ʼ��ѯ������=����ǰҳ��-1��*ÿҳ��ʾ������
        this.skipNo=(currentPage-1)*pageNo;
    }
    //���¼�����ҳ���ķ���
    public void reCountTotalPage(){
        //this.totalPage=totalCount % pageNo == 0 ? totalCount/pageNo : totalCount/pageNo +1;
        this.totalPage = (int)Math.ceil(this.totalCount * 1.0 / this.pageNo);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        //���¼�����ʼ�кţ���ʼ��ѯ����������ֵ
        reCountSkipNo();
        //���¼����Ƿ�����һҳ����ҳ������Ϊ��ǰҳ�Ÿı�ʱ����Ҫ�����Ƿ������һҳ��βҳ��
        reCountHasPrev();
    }
    //���¼����Ƿ�����һҳ����ҳ��
    public void reCountHasPrev(){
            //��ǰҳ�Ų�����1��ʱ��ʹ�����һҳ����ҳ��
            this.hasPrev = this.currentPage != 1;
    }
    //���¼����Ƿ�����һҳ��βҳ��
    public void reCountHasNext(){
        //��ǰҳ�Ų�������ҳ��ʱ�ʹ�����һҳ
        this.hasNext = this.currentPage != totalPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
        //���¼���ÿҳ��¼����ֵ
        reCountSkipNo();


    }


    public int getSkipNo() {
        return skipNo;
    }

    public void setSkipNo(int skipNo) {
        this.skipNo = skipNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        //���¼�����ҳ��
        reCountTotalPage();
        //���¼����Ƿ�����һҳ��βҳ����Ϊ���ܼ�¼���ı�ʱ����ҳ���ͻ�ı䣬��ҳ���ı��˾���Ҫ���¼����Ƿ�����һҳ��βҳ��
        reCountHasNext();
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isHasPrev() {
        return hasPrev;
    }

    public void setHasPrev(boolean hasPrev) {
        this.hasPrev = hasPrev;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}
