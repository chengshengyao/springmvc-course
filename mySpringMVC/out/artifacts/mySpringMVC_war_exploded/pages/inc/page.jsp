<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2020/12/15
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

共${pageBean.totalPage}页  共${pageBean.totalCount}条记录
当前第${pageBean.currentPage}页
<%--首页的条件是：当前页不等于1，必定存在首页 条件时当前页应等于1 --%>
<%--<c:if test="${pageBean.currentPage ne 1}">--%>
<c:if test="${pageBean.hasPrev}">
    <a href="${pageBean.url}&currentPage=1">首页</a>
</c:if>
<%--当前页号等于1，已经在第一页了，则首页超链接失效--%>
<%--<c:if test="${pageBean.currentPage eq 1}">--%>
<c:if test="${not pageBean.hasPrev}">
    首页
</c:if>
<%--上一页的条件是：当前页号不等于1，必定存在上一页，其原理和首页相同 ，上一页的条件是：当前页号-1  --%>
<%--<c:if test="${pageBean.currentPage ne 1}">--%>
<c:if test="${pageBean.hasPrev}">
    <a href="${pageBean.url}&currentPage=${pageBean.currentPage-1}">上一页</a>
</c:if>
<%--当前页号等于1，表示已经处于首页，故不存在上一页的说法--%>
<%--<c:if test="${pageBean.currentPage eq 1}">--%>
<c:if test="${not pageBean.hasPrev}">
    上一页
</c:if>
<%--下一页的条件是：当前页号不等于总页号时，必然存在下一页， 下一页的条件是：当前页号+1  --%>
<%--<c:if test="${pageBean.currentPage ne pageBean.totalPage}">--%>
<c:if test="${pageBean.hasNext}">
    <a href="${pageBean.url}&currentPage=${pageBean.currentPage+1}">下一页</a>
</c:if>
<%--<c:if test="${pageBean.currentPage eq pageBean.totalPage}">--%>
<c:if test="${not pageBean.hasNext}">
    下一页
</c:if>
<%--尾页：当前页号不等于总页号时 不然存在尾页 ， 尾页的条件是：当前页号就等于总页号--%>
<%--<c:if test="${pageBean.currentPage ne pageBean.totalPage}">--%>
<c:if test="${pageBean.hasNext}">
    <a href="${pageBean.url}&currentPage=${pageBean.totalPage}">尾页</a>
</c:if>
<%--<c:if test="${pageBean.currentPage eq pageBean.totalPage}">--%>
<c:if test="${not pageBean.hasNext}">
    尾页
</c:if>
去<input onchange="changePage(this);"/>页
<script>
    function changePage(input) {
        //1.确保用户输入的页号是纯数字：/^\d+$/
        //2.确保用户输入的页号介于首页和尾页之间的
        //3.开始跳转
        window.location.href="${pageBean.url}&currentPage="+input.value;
    }
</script>
去<select onchange="window.location.href='${pageBean.url}&currentPage='+this.value">
<c:forEach var="i" begin="1" end="${pageBean.totalPage}">
    <option value="${i}" ${pageBean.currentPage eq i ? "selected='selected'":""}>${i}</option>
</c:forEach>

</select>页