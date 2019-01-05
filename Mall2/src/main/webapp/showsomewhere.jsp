<%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/12/29
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>景点信息如下</title>
</head>
<body style="background-color: #CCDAF7">
<%
    int id = (int) request.getAttribute("tempid");
    String name = (String) request.getAttribute("tempname");
    String touse = (String) request.getAttribute("temptouse");

%>
<div class="divform">
<form action="main" method="post">
    <input type="hidden" name="oper" value="returnmain" />
<table border="1">
    <tr>
        <th>编号</th>
        <th>景点名称</th>
        <th>景点介绍</th>
    </tr>
        <tr>
            <td><%=id%></td>
            <td><%=name%></td>
            <td><%=touse%></td>
        </tr>
</table>
    <input type="submit" value="返回">
</form>
</div>
</body>
</html>
