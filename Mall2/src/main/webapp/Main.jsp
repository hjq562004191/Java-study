<%--
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
<style>
    body {
        margin-top:0px;
        margin-right:0px;
        margin-bottom:0px;
        margin-left:0px;
        background-color:#CCDAF7;
        background-image:url(image/map.jpeg);
        background-repeat:no-repeat;
        background-position:top;
        background-attachment:fixed;
    }
</style>
<body>

<form action="main" method="post">
    <br/>
    <input type="hidden" name="oper" value="select"/>
    <input type="submit" value="查询景点">
</form>
<form action="main" method="post">
    <br/>
    <input type="hidden" name="oper" value="select2"/>
    <input type="submit" value="路线查询">
</form>
<form action="addNode.jsp" method="post">
    <br/>
    <input type="submit" value="添加地点">
</form>
<form action="main" method="post">
    <input type="hidden" name="oper" value="select3"/>
    <br/>
    <input type="submit" value="删除地点">
</form>
<form action="main" method="post">
    <input type="hidden" name="oper" value="addRoad2"/>
    <br/>
    <input type="submit" value="添加路线">
</form>
<form action="main" method="post">
    <br/>
    <input type="hidden" name="oper" value="select4"/>
    <input type="submit" value="删除路线">
</form>
</body>
</html>
