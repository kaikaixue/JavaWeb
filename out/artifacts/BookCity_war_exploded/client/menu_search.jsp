<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/4/1
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="divmenu">
        <a href="#">文学</a>
        <a href="#">生活</a>
        <a href="#">计算机</a>
        <a href="#">外语</a>
        <a href="#">经营</a>
        <a href="#">励志</a>
        <a href="#">社科</a>
        <a href="#">学术</a>
        <a href="#">少儿</a>
        <a href="#">艺术</a>
        <a href="#">原版</a>
        <a href="#">科技</a>
        <a href="#">考试</a>
        <a href="#">生活百科</a>
        <a href="#" style="color: #FFFF00">全部商品列表</a>
    </div>
<div id="divsearch">
    <form action="#" id="searchform">
        <table width="100%" border="0" cellspacing="0">
            <tr>
                <td style="text-align: right; padding-right: 220px">
                    Search
                    <input type="text" name="textfield" class="inputtable" id="textfield" value="请输入书名" onmouseover="this.focus()" onclick="my_click(this, 'textfield');" onblur="my_blur(this, 'textfield')">
                    <a href="#">
                        <img src="/client/images/serchbutton.gif" alt="" border="0" style="margin-bottom: -4px" onclick="search()">
                    </a>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
