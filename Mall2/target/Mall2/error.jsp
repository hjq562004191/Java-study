<%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2019/1/1
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<body style="background-color: #CCDAF7">
<div class="divform">
    <form action="/main" method="post">
        <input type="hidden" name="oper" value="returnmain">
        <h1 style="color: red">转个圈就到啦!您就在原地哦!</h1>
        <br>
        <hr>
        <input type="submit" value="返回首页">
    </form>
</div>
</body>
</html>
