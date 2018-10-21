<%--
  Created by IntelliJ IDEA.
  User: 郝建强
  Date: 2018/10/14
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="good" method="post">
    <input type="hidden" name="oper" value="change">
    编号<input type="text" name="cid" value=""><br>
    名称<input type="text" name="gname" value=""/><br>
    类型<input type="text" name="gtype" value=""/><br>
    产地<input type="text" name="gchandi" value=""/><br>
    上架时间<input type="text" name="gdate" value=""/><br>
    库存<input type="text" name="gnum" value=""/><br>
    <input type="submit" name="确认修改" value="确认修改"/>
</form>

</form>
</body>
</html>
