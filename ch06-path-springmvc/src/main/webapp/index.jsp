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
<p>第一个springmvc项目</p>
<%--<p><a href="${pageContext.request.contextPath}/test/some.do">发起test/some.do的请求</a></p>--%>
<p><a href="test/some.do">发起test/some.do的请求</a></p>
</body>
</html>
