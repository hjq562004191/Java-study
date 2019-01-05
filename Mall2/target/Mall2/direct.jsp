<%@ page import="com.POJO.Node" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/12/29
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--直达景点--%>
<html>
<head>
    <title>查询路线</title>
</head>
<style type="text/css">
    .divform{
        width: 390px;
        height: 430px;
        text-align:center;
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
<form method="post" action="main" >
    <input type="hidden" name="oper" value="direct" />
   我的位置<select name="a" >
    <%
        for (Node node:list
                ) {%>
    <option value ="<%=node.getId()%>"><%=node.getName()%></option>
    <%
        }
    %>
   </select>
    <br>
    <hr>
    去的位置<select name="b" >
    <%
        for (Node node:list
                ) {%>
    <option value ="<%=node.getId()%>"><%=node.getName()%></option>
    <%
        }
    %>
</select>
    <br>
    <br>
    <input type="submit" name="" value="查询路线"/>
</form>
</div>
</body>
</html>
