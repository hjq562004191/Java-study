<%@ page import="com.POJO.Road" %>
<%@ page import="java.util.List" %>
<%@ page import="com.POJO.Node" %><%--
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
    List<Road> list = (List<Road>) request.getAttribute("Roadlist");
    List<Node> Nodelist = (List<Node>) request.getAttribute("Nodelist");
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
        <input type="hidden" name="oper" value="deletRoad"/>
        <h1 align="center">路线信息</h1>
        <hr/>
        <table>
            <tr>
                <td width="10%">路线：</td>
                <td width="20%" >
                    <select name="deletRoadid" >
                        <%
                            for (Road road:list
                                    ) {%>
                        <option value ="<%=road.getId()%>"><%=Nodelist.get(road.getFirst()-1).getName()+
                                "<-->"+Nodelist.get(road.getLast()-1).getName()%></option>
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
