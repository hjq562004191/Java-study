<%@ page import="com.POJO.Node" %>
<%@ page import="java.util.List" %><%--
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
<%
    List<Node> list = (List<Node>) request.getAttribute("Nodelist");
%>
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
    <form action="main" method="post">
        <input type="hidden" name="oper" value="deletNode"/>
        <h1 align="center">地点信息</h1>
        <hr/>
        <table>
            <tr>
                <td width="10%">地点名称：</td>
                <td width="20%" >
                    <select name="deletNodeid" >
                    <%
                        for (Node node:list
                                ) {%>
                    <option value ="<%=node.getId()%>"><%=node.getName()%></option>
                    <%
                        }
                    %>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="确定删除">
                </td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>
