<%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/10/14
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="good" method="get">
        <input type="hidden" name="oper" value="add"/>
        名称<input type="text" name="gname" value=""/><br>
        类型<input type="text" name="gtype" value=""/><br>
        产地<input type="text" name="gchandi" value=""/><br>
        上架时间<input type="text" name="gdate" value=""/><br>
        库存<input type="text" name="gnum" value=""/><br>
        <input type="submit" name="确认提交" value="确认提交"/>
    </form>
</body>
</html>
