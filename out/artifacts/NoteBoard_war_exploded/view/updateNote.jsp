<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/5/21
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.xkk.util.MySessionUtils" %>
<%@ page import="com.xkk.mapper.UserMapper" %>
<%@ page import="com.xkk.mapper.NoteMapper" %>
<%@ page import="com.xkk.bean.DO.NoteDO" %>
<%@ page import="com.xkk.bean.DO.UserDO" %><%--
  Created by IntelliJ IDEA.
  User: Fall
  Date: 2022/5/11
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    SqlSession sqlSession = MySessionUtils.getSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    NoteMapper noteMapper = sqlSession.getMapper(NoteMapper.class);
    NoteDO noteListDO = noteMapper.getNoteById(Integer.valueOf(request.getParameter("id")));
    UserDO userDO = userMapper.getInfo((Integer) session.getAttribute("id"));
%>
<form action="/NoteBoard/updateNote" method="post">
    <input type="text" name="id" value="<%out.print(noteListDO.getId());%>" style="display: none" />
    <input type="text" name="author" value="<%out.print(userDO.getName());%>" style="display: none" />
    <input type="text" name="title" value="<%out.print(noteListDO.getTitle());%>"/>
    <input type="text" name="content" value="<%out.print(noteListDO.getContent());%>"/>
    <input type="submit" />
</form>
</body>
</html>

