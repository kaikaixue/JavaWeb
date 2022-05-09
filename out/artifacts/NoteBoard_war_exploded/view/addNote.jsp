<%--
  Created by IntelliJ IDEA.
  User: Fall
  Date: 2022/4/21
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/NoteBoard/addNote" method="post">
    <input placeholder="标题" name="title"/>
    <input placeholder="内容" name="content"/>
    <input type="submit" />
</form>
</body>
</html>
