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
    <title>注册</title>

    <script>
        function check() {
            let username = document.getElementById("username");
            let password = document.getElementById("password");
            let confirmPass = document.getElementById("confirmPass");
            let email = document.getElementById("email");

            if (username.value == "" || password.value == "" || confirmPass.value == "" || email.value == "") {
                return false;
            } else if (password.value != confirmPass.value) {
                return false;
            } else {
                return true;
            }
        }
    </script>

</head>
<body>
    <h1>注册</h1>
    <form action="/review/registerServlet" method="post" onsubmit="return check()">
        用户名：<input type="text" name="username" id="username"> <br>
        密码：<input type="password" name="password" id="password"> <br>
        确认密码：<input type="password" name="confirmPass" id="confirmPass"> <br>
        邮箱： <input type="email" name="email" id="email"> <br>
        <input type="submit" value="提交">
        <a href="/review/view/login.jsp">已注册，去登录</a>
    </form>
</body>
</html>
