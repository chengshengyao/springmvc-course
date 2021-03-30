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
    <title>教师信息列表</title>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/datePicker/WdatePicker.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script>
        function deleteTeacher(id) {
            if (confirm("您确定要删除该信息吗?")){
                location.href="${pageContext.request.contextPath}/teacher/delete?teaId=" + id;
            }
        }
        function delBeath() {

            if($("[name=\"teaIds\"]:checked").length > 0){
                if (confirm("确认要删除选中内容吗?删除后不可恢复，请慎重此项操作！")){

                    //如果获取到选中状态的数组的长度是大于0的，说明用户至少选中了一项
                    //此时提交批量删除
                    $("#teaForm").submit();
                }
            }else{
                //说明用户一项都没选
                alert("请至少选择一项进行删除！");
            }
        }
        /*window.onload=function () {
            //1.获取第一个cb
            document.getElementById("firstCb").onclick = function(){
                //2.获取下边列表中所有的cb
                var cbs = document.getElementsByName("teaIds");
                //3.遍历
                for (var i = 0; i < cbs.length; i++) {
                    //4.设置这些cbs[i]的checked状态 = firstCb.checked
                    cbs[i].checked = this.checked;
                }
            }
        }*/
        $(function () {
            $("#firstCb").click(function () {
                // $("[name=\"teaIds\"]").prop("checked",this.checked);
                $("[name=\"teaIds\"]").prop("checked",$(this).prop("checked"));
            });
        });
    </script>

</head>
<body>

    <center>
        <p style="font-size: 35px; color: darkcyan;margin-top: 30px"/>教师信息列表
         <form action="${pageContext.request.contextPath}/teacher/list">
            姓名：<input type="text"  name="teaName" value="${teacher.teaName}"  placeholder="请输入教师姓名"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            年龄：<input type="text"  name="teaAgeBegin" value="${teacher.teaAgeBegin}" placeholder="请输入教师年龄"/>至
                 <input type="text"  name="teaAgeEnd" value="${teacher.teaAgeEnd}" placeholder="请输入教师年龄"/> &nbsp;&nbsp;&nbsp;&nbsp;
            性别：<input type="radio" name="teaSex" value=""${empty teacher.teaSex ? "checked='checked'":""} />不限
                 <input type="radio" name="teaSex" value="男"${teacher.teaSex eq 男 ? "checked='checked'":""} />男
                 <input type="radio" name="teaSex" value="女"${teacher.teaSex eq 女 ? "checked='checked'":""}/>女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <input type="submit" value="查询"/><br>
            入职日期:
                 <input type="text" name="teaDateBegin" value="${teacher.teaDateBegin}" class="Wdate" onClick="WdatePicker();" readonly="readonly"/> 至
                 <input type="text" name="teaDateEnd" value="${teacher.teaDateEnd}" class="Wdate" onClick="WdatePicker();" readonly="readonly" />
         </form>
        <form id="teaForm" action="${pageContext.request.contextPath}/teacher/deleteBeath" method="post">
            <table border="1px" style="margin-top: 30px;height: 250px;width: 500px">
            <tr align="center">
                <th><input type="checkbox" id="firstCb"/>全选/取消</th>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>入职日期</th>
                <th>操作</th>
            </tr>
            <c:forEach var="teacher" items="${teacherList}" varStatus="s">
            <tr align="center">
                    <td><input type="checkbox" name="teaIds" value="${teacher.teaId}"/></td>
                    <td>${s.count}</td>
                    <td>${teacher.teaName}</td>
                    <td>${teacher.teaAge}</td>
                    <td>${teacher.teaSex}</td>
                    <td>${teacher.teaDate}</td>
                <td>
                    <a  href="${pageContext.request.contextPath}/teacher/edit?teaId=${teacher.teaId}">修改</a>&nbsp;
                    <a  href="javascript:deleteTeacher(${teacher.teaId})">删除</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        </form>
        <a href="${pageContext.request.contextPath}/teacher/edit">添加教师</a> <a href="javascript:delBeath();">删除选中</a><br>
        <%@ include file="/pages/inc/page.jsp"%>
        <input  type="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/'"/>
    </center>

</body>
</html>
