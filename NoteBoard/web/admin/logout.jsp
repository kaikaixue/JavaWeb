<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.xkk.mapper.UserMapper" %>
<%@ page import="com.xkk.bean.DTO.UpdateActiveDTO" %>
<%@ page import="com.xkk.util.MySessionUtils" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/5/9
  Time: 15:47
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
        UpdateActiveDTO updateActiveDTO = UpdateActiveDTO.builder()
                .active(0)
                .id((Integer) session.getAttribute("id"))
                .build();
        userMapper.updateActive(updateActiveDTO);
        sqlSession.commit();
        session.removeAttribute("id");
        session.removeAttribute("name");
        response.sendRedirect("/NoteBoard/admin/login.jsp");
    %>
</body>
</html>
