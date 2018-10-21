<%@ page import="java.util.List" %>
<%@ page import="user.User" %><%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/10/14
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看数据</title>
</head>
<body>
<table border="1">
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>类型</th>
        <th>产地</th>
        <th>时间</th>
        <th>库存</th>
        <th>操作</th>

    </tr>

        <%
            List<User> list = (List<User>) request.getAttribute("list");
            for (User i:list
                 ) {%>
    <tr>
        <td><%=i.getId()%></td>
        <td><%=i.getGname()%></td>
        <td><%=i.getType()%></td>
        <td><%=i.getChandi()%></td>
        <td><%=i.getDate()%></td>
        <td><%=i.getNum()%></td>
        <th>删除</th>
    </tr>
    <% }%>
    <form action="chance.jsp"/>
    <input type="submit" name="确定" value="确定">
</table>
</body>
</html>
