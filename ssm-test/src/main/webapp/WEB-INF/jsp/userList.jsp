<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>查询用户列表</title>
</head>

<body>
<table width="25%" border=1 cellspacing="0">
<tr align="center">
    <td>id</td>
	<td>账户</td>
	<td>密码</td>
	<td>功能</td>
</tr>
<c:forEach items="${userList}" var="user">
<tr align="center">
    <td>${user.ID}</td>
    <td>${user.NAME}</td>
    <td>${user.PASSWORD}</td>
	<td>
        <a href="${pageContext.request.contextPath }/userEdit.action?id=${user.ID}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="${pageContext.request.contextPath }/userDelete.action?id=${user.ID}" onclick="return confirm('确定要删除吗？')">删除</a>
    </td>
</tr>
</c:forEach>
</table>
</body>
</html>