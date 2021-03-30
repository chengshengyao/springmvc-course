<%--
  Created by IntelliJ IDEA.
  User: chengshengyao
  Date: 2021/1/16
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>/WEB-INF/view/subview/fuck.jsp从request作用域获取数据</h2><br>
<h3>myname数据：${param.myname}</h3><br>
<h3>myage数据：${param.myage}</h3><br>
<h3>取参数数据：<%=request.getParameter("myname")%></h3>
</body>
</html>
