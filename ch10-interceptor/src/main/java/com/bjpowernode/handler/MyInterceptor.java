package com.bjpowernode.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @ProjectName: springmvc-course
 * @Package: com.bjpowernode.handler
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/20 21:15
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
//拦截器类拦截用户请求
public class MyInterceptor implements HandlerInterceptor {
    private long beginTime=0;
    @Override
    //预处理方法在控制器方法之前先执行 handler被拦截的控制器对象
    //此方法可以验证用户是否登录，是否 有权限访问某个地址
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor拦截器的预处理方法【preHandle】执行【处理对控制器方法是否放行】");
        //request.getRequestDispatcher("/tips.jsp").forward(request,response);
        return true;
    }

    @Override
    //后处理方法在控制器方法之后先执行 handler被拦截的控制器对象 modelAndView 返回值
    //能获取到处理器方法的返回值，可对控制器方法的返回值进行 操控
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        beginTime=System.currentTimeMillis();
        System.out.println("MyInterceptor拦截器的后处理方法【postHandle】执行【可对控制器方法的返回值进行 操控】");
        //对原来的控制器方法执行结果，进行操控调整
        if(modelAndView!=null){
            modelAndView.addObject("mydate",new Date());
            modelAndView.setViewName("other");
        }
    }

    @Override
    //最后执行的方法 Exception ex 程序中发生的异常
    //竣工 请求处理完成后 对视图执行了forward后
    //一般是做资源回收工作.在程序请求过程中所创建的对象，在此删除，把占用的资源回收
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime=System.currentTimeMillis();
        System.out.println("MyInterceptor拦截器的竣工方法【afterCompletion】" +
                "执行【资源回收工作.在程序请求过程中所创建的对象，在此删除，把占用的资源回收】");
        System.out.println("计算拦截器的预处理方法到竣工方法完成时间"+(endTime-beginTime));
    }
}
