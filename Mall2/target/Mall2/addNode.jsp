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
    <title>添加地点</title>
</head>
<style type="text/css">
    .divform{
        width: 390px;
        height: 430px;

        align-content: center;
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
        <input type="hidden" name="oper" value="addNode"/>
        <h1 align="center">地点信息</h1>
        <hr/>
        <table>
            <tr>
                <td width="10%">地点名称</td>
                <td width="20%" ><input type="text" name="addNodename" value="" /></td>
            </tr>
            <tr>
                <td>地点简介</td>
                <td>
                    <textarea name="addNodetouse" cols="30%" rows="5%" ></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="确定添加">
                </td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>
