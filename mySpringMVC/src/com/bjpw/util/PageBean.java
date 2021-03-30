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
 * @Description: java类作用描述
 * @Author: 程生鹏
 * @CreateDate: 2020/12/14 11:20
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class PageBean {
    //当前页码
    private int currentPage=1;
    //每页记录数
    private int pageNo=10;
    //起始行号(开始查询的索引)
    private int skipNo=0;
    //总记录数
    private int totalCount = 0;
    //总页数
    private int totalPage = 1;
    private String url;
    //是否有上一页
    private boolean hasPrev=false;
    //是否有下一页
    private boolean hasNext=false;

    public PageBean() {

        //从线程当中获取请求
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        //获取当前的请求地址
        String uri = request.getRequestURI()+"?1=1";
        //获得请求当中所有的参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        //遍历枚举，迭代所有的参数名称
        while (parameterNames.hasMoreElements()){
            //取出参数名称
            String paramName = parameterNames.nextElement();
            //取出参数名称所对应的值
            String paramValue = request.getParameter(paramName);
            //如果参数的值不为空，则拼接到当前请求地址的参数列表中
            if (paramValue != null && !"".equals(paramValue) && !"1".equals(paramName)&& !"currentPage".equals(paramName)) {
                //对地址栏参数左转码
                try {
                    paramValue = URLEncoder.encode(paramValue,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                uri += "&"+ paramName+"="+paramValue;
            }
        }
        //为url属性赋值
        url = uri;
    }

    //重新计算开始查询的索引的方法
    public void reCountSkipNo(){
        //开始查询的索引=（当前页码-1）*每页显示的条数
        this.skipNo=(currentPage-1)*pageNo;
    }
    //重新计算总页数的方法
    public void reCountTotalPage(){
        //this.totalPage=totalCount % pageNo == 0 ? totalCount/pageNo : totalCount/pageNo +1;
        this.totalPage = (int)Math.ceil(this.totalCount * 1.0 / this.pageNo);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        //重新计算起始行号（开始查询的索引）的值
        reCountSkipNo();
        //重新计算是否有上一页（首页）（因为当前页号改变时就需要计算是否存在上一页和尾页）
        reCountHasPrev();
    }
    //重新计算是否有上一页（首页）
    public void reCountHasPrev(){
            //当前页号不等于1的时候就存在上一页（首页）
            this.hasPrev = this.currentPage != 1;
    }
    //重新计算是否有下一页（尾页）
    public void reCountHasNext(){
        //当前页号不等于总页号时就存在下一页
        this.hasNext = this.currentPage != totalPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
        //重新计算每页记录数的值
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
        //重新计算总页数
        reCountTotalPage();
        //重新计算是否有下一页（尾页）因为当总记录数改变时，总页数就会改变，总页数改变了就需要重新计算是否有下一页（尾页）
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
