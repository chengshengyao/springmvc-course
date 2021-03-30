<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户信息</title>

</head>
<body>
	<form id="Form"	action="${pageContext.request.contextPath }/add.action" method="post">
		<h3>添加用户信息：</h3>
		<table width="16%" border=1 cellspacing="0">
			<tr>
				<td>账户</td>
				<td><input type="text" name="NAME"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="PASSWORD"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>