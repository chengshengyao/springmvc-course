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
        System.out.println("验证用户登录信息，正确返回真，其他返回假");
        String strName_login ="";
        Object name = request.getSession().getAttribute("name");
        if (name != null) {
             strName_login= (String) name;

        }
        if (!"zs".equals(strName_login)) {
            //用户提示页面
            request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return  false;
        }
        //为zs登录情况下
        return true;
    }
}
