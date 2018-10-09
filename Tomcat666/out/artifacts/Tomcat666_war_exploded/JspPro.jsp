<%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/10/9
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<%@ page errorPage="errorJsp.jsp" %>
<%
    int i = 5/0;
%>
<%--
    jsp的三种注释
        前端语言注释：
            会被转译，也会被发送，但是不会被浏览器执行。
        Java语言注释：
            会被转译，但是不会被servlet执行。
        jsp注释：
            不会被转译。

    jsp page指令学习
    <%@page 属性名 ="属性名" 属性名="属性值"。。。%>
    language ： 声明jsp要转译的语言
    import： 声明转译的Java文件要导入的包，不同的包要使用逗号隔开
    pageEncoding :设置jsp文件的数据编码格式
    contentType="text/html;charset=UTF-8"：响应浏览器时，浏览器的解析和编码格式
--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form>--%>
    <%--<input type="text" name="aaa" value="">--%>
    <%--<input type="submit" name="啊啊啊">--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<b>哈哈哈哈哈哈哈哈哈</b>