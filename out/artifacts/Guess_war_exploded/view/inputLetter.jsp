<%@ page import="java.nio.charset.StandardCharsets" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/4/9
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Guess/guessLetter">
    <table>
        <tr>
            <td>输入你的猜测</td>
            <td><input type="text" name="input"> <input type="submit" value="提交"></td>
        </tr>
        <tr>
            <td>提示信息</td>
            <td><%
                request.setCharacterEncoding("utf-8");
                String result = request.getParameter("result");
                if (result == null) {
                    out.print("请猜字母");
                } else {
                    out.print(result);
                }
            %></td>
        </tr>
        <tr>
            <td>单机按钮重新开始</td>
            <td><input type="button" value="随机得到一个字母"></td>
        </tr>
    </table>
</form>
</body>
</html>
