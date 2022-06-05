<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/6/5
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h1>登录</h1>
    <form action="/review/loginServlet">
        用户名：<input type="text" name="username"> <br>
        密码：<input type="password" name="password"> <br>
        <input type="submit" value="提交">
    </form>
    <a href="/review/view/register.jsp">还未注册，去注册</a>
</body>
</html>
