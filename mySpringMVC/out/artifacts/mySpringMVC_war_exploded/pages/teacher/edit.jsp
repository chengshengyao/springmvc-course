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
    <title>添加教师</title>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/datePicker/WdatePicker.js"></script>
</head>
<body>
    <center>
        <h3 style="font-size: 35px; color: darkcyan;margin-top: 40px">添加教师页面</h3>
        <form action="${pageContext.request.contextPath}/teacher/save" method="post">
            <input type="hidden" name="teaId" value="${teacher.teaId}"/>
            <table border="1px" style="margin-top: 50px;height: 200px;width: 300px">
                <tr>
                    <td>姓名</td>
                    <td><input type="text"  name="teaName" value="${teacher.teaName}" placeholder="请输入姓名"></td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td><input type="text"  name="teaAge" value="${teacher.teaAge}" placeholder="请输入年龄"></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td>
                        <input type="radio" name="teaSex" value="男" ${teacher.teaSex eq "男" ? "checked='checked'":""} />男
                        <input type="radio" name="teaSex" value="女" ${teacher.teaSex eq "女" ? "checked='checked'":""}/>女
                    </td>
                </tr>
                <tr>
                    <td>入职日期</td>
                    <td>
                        <input type="text" name="teaDate" value="${teacher.teaDate}" class="Wdate" onClick="WdatePicker();" readonly="readonly"/>
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
            <input  type="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/teacher/list'"/>
        </form>
    </center>

</body>
</html>
