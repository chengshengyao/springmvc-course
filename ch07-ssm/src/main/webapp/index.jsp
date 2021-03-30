<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>【首页】</title>
    <base href="<%=basePath%>">
</head>
<body>
<div align="center">
    <h2>项目模块功能入口</h2>
    <img src="images/p4.jpg" alt="兄弟，图片是静态资源...">
    <table>
        <tr>
            <td><a href="registerStudent.jsp">注册学生</a></td>
        </tr>
        <tr>
            <td><a href="queryStudents.jsp">查询信息</a> </td>
        </tr>
    </table>
</div>

</body>
</html>
