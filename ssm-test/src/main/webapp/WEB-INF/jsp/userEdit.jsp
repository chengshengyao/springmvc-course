<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>

</head>
<body>
	<form id="userForm"	action="${pageContext.request.contextPath }/updateUser.action" method="post">
		<input type="hidden" name="ID" value="${user.ID}" />
		<h3>修改用户信息</h3>
		<table width="16%" border=1 cellspacing="0">
			<tr>
				<td>账户</td>
				<td><input type="text" name="NAME" value="${user.NAME}" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="PASSWORD" value="${user.PASSWORD}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>