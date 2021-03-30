<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2020/12/15
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<center>
    <c:if test="${not empty LOGIN_USER}">
        ${LOGIN_USER.username}，欢迎您
        <a href="${pageContext.request.contextPath}/logout" style="text-decoration:none;font-size:33px;">
            退出
        </a>
    </c:if>
    <c:if test="${empty LOGIN_USER}">
        <a href="${pageContext.request.contextPath}/login" style="text-decoration:none;font-size:33px">
            登录
        </a>
    </c:if>
   <br>
    <a href="${pageContext.request.contextPath}/student/list" style="text-decoration:none;font-size:33px">
        学生管理
    </a>
    <br>
    <a href="${pageContext.request.contextPath}/teacher/list" style="text-decoration:none;font-size:33px">
        教师管理
    </a>
</center>

</body>
</html>
