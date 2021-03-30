<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2020/12/16
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    省：
        <select>
            <c:forEach items="${cities}" var="city">
                <option>${city.cname}</option>
            </c:forEach>
        </select>
</body>
</html>
