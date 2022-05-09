<%@ page import="com.xkk.domain.DO.UserDO" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.xkk.util.MySessionUtils" %><%--
  Created by IntelliJ IDEA.
  User: Fall
  Date: 2022/4/21
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body style="width: 100%; align-items: center; display: flex; justify-content: center; flex-direction: column">
<h1>登录成功</h1>
<%
    SqlSession sqlSession= MySessionUtils.getSession();
    System.out.println("--------------------------" + session.getAttribute("id"));
    UserDO userDO = sqlSession.selectOne("com.xkk.mapper.UserMapper.getInfo",(Integer) session.getAttribute("id"));
%>
<h1><% out.print(userDO.getName()); %></h1>
<h1>您是第<% out.print(request.getParameter("logins")); %>位访客</h1>
<a href="/Notes/view/message.jsp">进入留言板</a>
</body>
</html>
