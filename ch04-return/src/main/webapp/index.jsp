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
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                $.ajax({
                    //url:"returnVoid-ajax.do",
                    // url:"returnStudentJson.do",
                    //url: "returnStudentJson.do",
                    url:"returnStringDate.do",
                    data: {
                        name: "zhangsan",
                        age: 20
                    },
                    type: "post",
                    //dataType: "json",
                    dataType: "text",
                    success: function (resp) {

                        //alert(resp.name+" "+resp.age);
                        // $.each(resp, function (i, n) {
                        //     alert(n.name + "  " + n.age)
                        // })
                        alert("返回的是文本数据"+resp)
                    }
                })
            })
        })
    </script>
</head>
<body>


<p style="color: red">处理器方法返回String表示视图名称</p>
<form action="returnString-view.do" method="post">
    姓名：<input type="text" name="name"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="提交参数">
</form>

<p style="color: green">处理器方法返回String表示视图完整路径名称</p>
<form action="returnString-view2.do" method="post">
    姓名：<input type="text" name="name"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="提交参数">
</form>
<br>


<button id="btn">发起ajax请求</button>
</body>
</html>
