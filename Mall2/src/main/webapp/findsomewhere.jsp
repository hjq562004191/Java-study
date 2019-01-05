<%@ page import="java.util.List" %>
<%@ page import="com.POJO.Node" %><%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/12/29
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>欢迎使用西邮导航系统</title>
</head>
<style type="text/css">
    .divform{
        width: 390px;
        height: 430px;

        border: 5px solid black;
        top: 50%;
        left: 50%;
        margin-top: 70px;
        margin-left: 35%;
    }
</style>
<%
    List<Node> list = (List<Node>) request.getAttribute("Nodelist");
%>
<body style="background-color: #CCDAF7">
<div class="divform">
<h2>查询景点</h2>
<form action="/main" method="post">
    <input type="hidden" name="oper" value="find"/>
    <select name="nameselect" >

        <%
            for (Node node:list
                 ) {%>
        <option value ="<%=node.getId()%>"><%=node.getName()%></option>
        <%
            }
        %>
    </select>
    <input type="submit" value="查询"/>
</form>
</div>
</body>
</html>
