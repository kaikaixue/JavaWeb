<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.xkk.mapper.UserMapper" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/5/9
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录成功</title>
</head>
<body style="width: 100%; align-items: center; display: flex; justify-content: center; flex-direction: column">
<%--<h1><% out.print(request.getParameter("account")); %></h1>--%>
<h1>登录成功！欢迎<% out.print(request.getParameter("name")); %>光临留言板</h1>
<a href="/NoteBoard/admin/userManager.jsp">用户管理</a>
</body>
</html>