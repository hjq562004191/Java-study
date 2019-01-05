<%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/12/30
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>最短路径</title>
</head>
<style type="text/css">
    .divform{
        width: 800px;
        height: 650px;
        border: 5px solid black;
        top: 50%;
        left: 50%;
        margin-top: 50px;
        margin-left: 10%;
    }
</style>
<%
    int distance = (int) request.getAttribute("distance");
    String directname = (String) request.getAttribute("directname");
    String direct = (String) request.getAttribute("direct");
    int num = (int) request.getAttribute("num");
    String direct2 = (String) request.getAttribute("direct2");
    String[] allRoads = (String[]) request.getAttribute("allroads");
%>
<body style="background-color: #CCDAF7">
    <form action="/main" method="post">
        <div class="divform">
        <input type="hidden" name="oper" value="returnmain">
        <h2><%=directname%>  的路线<h2/>
            <h3>最短路线为<%=distance%>m</h3>
            <hr>
                <%=direct%>
            <br>
            <h3>最少经过地点为<%=num%>个地点</h3>
            <hr>
                <%=direct2%>
            <br>
            <h3>全部路线</h3>
            <hr><%
            int i = 0;
            for(i = 0; i < allRoads.length; i++) {
              if (allRoads[i] == null){
                  break;
              }else {%>
                <%=allRoads[i]%>
            <br>
              <%}
            }
            num = i;
            %>
            <br>
            <h3>全部共<%=num%>路线</h3>
            <br>
            <hr>
            <input type="submit" value="确认">
        </div>
    </form>
</body>
</html>
