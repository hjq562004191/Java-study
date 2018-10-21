<%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/10/14
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="add.jsp">
    <input type="hidden" name="oper" value="add">
    <input type="submit" name="添加" value="添加">
</form>
<form method="get" action="dele.jsp">
    <input type="submit" name="删除" value="删除">
</form>
<form method="get" action="find.jsp">
    <input type="submit" name="修改" value="修改">
</form>
<form method="get" action="good">
    <input type="hidden" name="oper" value="read">
    <input type="submit" name="查看" value="查看">
</form>
</body>
</html>
