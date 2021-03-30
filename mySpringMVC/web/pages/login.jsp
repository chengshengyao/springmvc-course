<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2020/12/15
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <center>
        <div style="color: red">${users.msg}</div>
        <form action="${pageContext.request.contextPath}/saveLogin" method="post">
            用户名：
                <input type="text" name="username"/><br>
            密&nbsp;&nbsp;&nbsp;码：
                <input type="password" name="password"/>
            <input type="submit" value="登录"/>
        </form>
    </center>
</body>
</html>
