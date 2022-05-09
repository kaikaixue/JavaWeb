<%@ page import="com.xkk.domain.DO.UserDO" %>
<%@ page import="com.xkk.mapper.UserMapper" %>
<%@ page import="org.apache.catalina.User" %>
<%@ page import="javax.annotation.Resource" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.xkk.util.MySessionUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
  <script type="text/javascript">
    function refresh() {
      location.reload();
    }
  </script>
</head>
<%
  SqlSession sqlSession= MySessionUtils.getSession();
  if (session.getAttribute("id") != null) {
    UserDO userDO = sqlSession.selectOne("com.xkk.mapper.UserMapper.getInfo",(Integer) session.getAttribute("id"));
    if (userDO.getActive()) {
      response.sendRedirect("/message.jsp");
      return;
    }
  }
%>
<body>
<div class="card">
  <h2>JSP学习论坛留言板 - 前台登录</h2>
  <form action="/Notes/noteLogin" method="post">
    <div class="input">
      账号
      <input type="text" name="account"/>
    </div>
    <div class="input">
      密码
      <input type="password" name="password"/>
    </div>
    <div class="input">
      系统验证码
      <div onclick="refresh()"><img src="/Notes/verifyCode" /></div>
    </div>
    <div class="input">
      输入验证码
      <input type="text" name="code"/>
    </div>
    <div class="input">
      <input type="submit"/>
      <input type="reset"/>
    </div>
  </form>
  <a href="/view/logon.jsp">还没注册?请点击注册!</a>
</div>
</body>
</html>