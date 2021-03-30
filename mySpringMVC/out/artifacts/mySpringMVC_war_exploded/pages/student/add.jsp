<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2020/12/12
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
    <center>
        <h3 style="font-size: 35px; color: darkcyan;margin-top: 40px">添加学生页面</h3>
        <form action="${pageContext.request.contextPath}/student/save" method="post">
            <table border="1px" style="margin-top: 50px;height: 200px;width: 300px">
                <tr>
                    <td>姓名</td>
                    <td><input type="text"  name="stuName" placeholder="请输入姓名"></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td>
                        <input type="radio" name="stuSex" value="0" checked="checked"/>男
                        <input type="radio" name="stuSex" value="1"/>女
                    </td>
                </tr>
                <tr>
                    <td>在校状态</td>
                    <td>
                        <input type="radio" name="stuStatus" value="0" checked="checked"/>离校
                        <input type="radio" name="stuStatus" value="1"/>在校
                    </td>
                </tr>
                <tr>
                    <td>任课老师</td>
                    <td>
                        <select name="teaId">
                            <option value="">--请选择任课老师--</option>
                            <c:forEach var="teacher" items="${teacherList}">
                                <option value="${teacher.teaId}">${teacher.teaName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input  type="submit" value="提交" />
                    </td>
                    <td>
                        <input  type="reset" value="重置" />
                    </td>
                </tr>
            </table>
            <input  type="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/student/list'"/>
        </form>
    </center>

</body>
</html>
