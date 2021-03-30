<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2020/12/12
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息列表</title>
    <script>
        function deleteStudent(id) {
            if (confirm("您确定要删除这条学生信息吗?")){
                location.href="${pageContext.request.contextPath}/student/del?stuId="+id;
            }
        }
    </script>
</head>
<body>

    <center>
        <p style="font-size: 35px; color: darkcyan;margin-top: 50px">学生信息列表</p>
        <form action="${pageContext.request.contextPath}/student/list" method="post">
            姓名：<input type="text" name="stuName" value="${param.stuName}" placeholder="请输入学生姓名"/>&nbsp;&nbsp;&nbsp;&nbsp;
            性别：<input type="radio" name="stuSex" value=""${empty param.stuSex ? "checked='checked'":""} />不限
                 <input type="radio" name="stuSex" value="0"${param.stuSex eq 0 ? "checked='checked'":""} />男
                 <input type="radio" name="stuSex" value="1"${param.stuSex eq 1 ? "checked='checked'":""}/>女 &nbsp;&nbsp;&nbsp;&nbsp;
            在校状态：<input type="radio" name="stuStatus" value=""${empty param.stuStatus ? "checked='checked'":""} checked="checked"/>不限
                    <input type="radio" name="stuStatus" value="0"${param.stuStatus eq 0 ? "checked='checked'":""}/>离校
                    <input type="radio" name="stuStatus" value="1"${param.stuStatus eq 1 ? "checked='checked'":""}/>在校&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit" value="检索"/>
        </form>
        <table border="1px" style="margin-top: 50px;height: 250px;width: 500px">
            <tr align="center">
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>在校状态</th>
                <th>任课老师</th>
                <th>操作</th>
            </tr>
            <c:forEach var="student" items="${studentList}" varStatus="s">
            <tr align="center">
                    <td>${s.count}</td>
                    <td>${student.stuName}</td>
                    <td>${student.stuSex eq 0 ? "男":"女"}</td>
                    <td>${student.stuStatus eq 0 ? "离校":"在校"}</td>
                    <td>${student.teacher.teaName}</td>
                <td><a  href="${pageContext.request.contextPath}/student/edit?stuId=${student.stuId}">修改</a>&nbsp;
                    <a  href="javascript:deleteStudent(${student.stuId})">删除</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/student/add">添加学生</a><br>
        <%@ include file="/pages/inc/page.jsp"%>
        <input  type="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/'"/>
    </center>

</body>
</html>
