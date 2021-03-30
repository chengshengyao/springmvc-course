<%--
  Created by IntelliJ IDEA.
  User: chengshengyao
  Date: 2021/1/16
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>
<p>控制器方法返回ModelAndView实现forward</p>
<form action="doForward.do" method="post">
    姓名：<input type="text" name="name"><br>
    年龄：<input type="text" name="age"><br>
    <input type="submit" value="提交请求">
</form><br>
<p>控制器方法返回ModelAndView实现redirect</p>
<form action="doRedirect.do" method="post">
    姓名：<input type="text" name="name"><br>
    年龄：<input type="text" name="age"><br>
    <input type="submit" value="提交请求">
</form>
</body>
</html>
