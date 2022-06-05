<%--
  Created by IntelliJ IDEA.
  User: Fall
  Date: 2022/4/12
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
<%--    <link href="../css/global.css" type="text/css"/>--%>
    <script>
        function change(value) {
            document.getElementById("avatar").src = value
        }
    </script>
    <style>
        .main {
            width: 100%;
            align-items: center;
            display: flex;
            justify-content: center;
        }

        .card {
            /*margin-left: 500px;*/
            width: 500px;
            height: 420px;
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            align-items: center;
        }

        .input {
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            margin: 20px;
            width: 400px;
        }
    </style>
</head>
<body class="main">
<div class="card">
    <h2>用户注册</h2>
    <form method="post" action="/NoteBoard/logon">
        <div class="input">
            账号
            <input type="text" name="account" />
        </div>
        <div class="input">
            头像
            <select name="image" onchange="change(value)">
                <option value="../image/avatar_3.jpg" selected>1</option>
                <option value="../image/avatar_4.jpg">2</option>
<%--                <option value="/NoteBoard/image/x.jpg">3</option>--%>
            </select>
            <img id="avatar" src="../image/avatar_3.jpg" width="60" height="60"/>
        </div>
        <div class="input">
            密码
            <input type="password" name="password" />
        </div>
        <div class="input">
            邮件
            <input type="text" name="email" />
        </div>
        <div style="margin-left: 150px">
            <input type="submit"/>
            <input type="reset" />
            <a href="/view/login.jsp"> 点此登录 </a>
        </div>
        <input name="flag" value="0" style="display: none" />
    </form>
</div>
</body>
</html>
