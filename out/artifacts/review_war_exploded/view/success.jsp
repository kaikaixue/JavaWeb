<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/6/5
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    欢迎 <% out.print(request.getParameter("username")); %>， 登录成功
</body>
</html>
