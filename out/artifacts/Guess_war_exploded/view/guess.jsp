<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/4/9
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% String charString = new String("abcdefghijklmnopqrstuvwxyz");
        char c = charString.charAt((int)(Math.random() * 26));
//        Character tempCharacter = new Character(charString.charAt(charNumber));
        session.setAttribute("tempCharacter", c);
    %>
    访问或刷新该页面可以随机得到一个英文字母 <br>
    单机超链接去猜出这个字母: <a href="inputLetter.jsp">去猜字母</a>
</body>
</html>
