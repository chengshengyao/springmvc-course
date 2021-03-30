<%--
  Created by IntelliJ IDEA.
  User: chengshengyao
  Date: 2021/1/21
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>模拟登出</h2>
<h4>退出系统，从session中删除数据</h4>
<%=session.removeAttribute("name")%>
</body>
</html>
