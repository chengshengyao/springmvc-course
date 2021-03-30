package com.bjpowernode.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class MyInterceptor implements HandlerInterceptor {
    private long beginTime = 0;

    @Override

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("1MyInterceptor拦截器的预处理方法【preHandle】执行【处理对控制器方法是否放行】");

        return true;
    }

    @Override

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        beginTime = System.currentTimeMillis();
        System.out.println("1MyInterceptor拦截器的后处理方法【postHandle】执行【可对控制器方法的返回值进行 操控】");

        if (modelAndView != null) {
            modelAndView.addObject("mydate", new Date());
            modelAndView.setViewName("other");
        }
    }

    @Override

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        System.out.println("1MyInterceptor拦截器的竣工方法【afterCompletion】" +
                "执行【资源回收工作.在程序请求过程中所创建的对象，在此删除，把占用的资源回收】");
        System.out.println("1计算拦截器的预处理方法到竣工方法完成时间" + (endTime - beginTime));
    }
}
