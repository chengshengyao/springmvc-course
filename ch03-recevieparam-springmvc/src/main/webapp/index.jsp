<%--
  Created by IntelliJ IDEA.
  User: chengshengyao
  Date: 2021/1/16
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p style="color: red">提交参数至控制器</p>

<form action="receiveproperty.do" method="post">
    姓名：<input type="text" name="name"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="提交参数">
</form>

<p style="color: green">提交参数时参数名，和处理器方法的形参名不一样</p>
<form action="receiveparam.do" method="post">
    姓名：<input type="text" name="rname"><br>
    年龄:<input type="text" name="rage"><br>
    <input type="submit" value="提交参数">
</form>

<p style="color: yellow">使用java对象接收请求参数</p>
<form action="receiveobject.do" method="post">
    姓名：<input type="text" name="name"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="提交参数">
</form>
</body>
</html>
