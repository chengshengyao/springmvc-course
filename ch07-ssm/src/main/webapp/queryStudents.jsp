<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>查询学生信息</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            //当前页面调用dom对象加载后，执行异步请求
            loadStudentInfo();
            $("#btnLoader").click(function () {
                //调用异步请求
                loadStudentInfo();
            })
        })

        function loadStudentInfo() {
            $.ajax({
                url: "student/queryStudent.do",
                type: "get",
                dataType: "json",
                success: function (resp) {
                    //清除所加载的旧数据
                    $("#info").html("")
                    //加载新数据
                    $.each(resp, function (i, n) {
                        $("#info").append("<tr>")
                            .append("<td>" + n.id + "</td>")
                            .append("<td>" + n.name + "</td>")
                            .append("<td>" + n.age + "</td>")
                            .append("</tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
<div align="center">
    <table>
        <thead>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>年龄</td>
        </tr>
        </thead>
        <tbody id="info">
        </tbody>
    </table>
    <input type="button" id="btnLoader" value="加载数据">
</div>

</body>
</html>
