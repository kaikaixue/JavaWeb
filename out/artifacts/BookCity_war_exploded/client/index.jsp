<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/4/1
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css" type="text/css">
<%--    导入首页轮播图css和js脚本--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/autoplay.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/client/js/autoplay.js"></script>
</head>
<body class="main">
<%--    1.传智商城顶部 start--%>
<%@include file="head.jsp"%>
<%--传智商城顶部 end--%>
<%--2.传智商城菜单列表 start--%>
<%@include file="menu_search.jsp"%>
<%--传智商城菜单列表 end--%>

<%--3.传智书城首页轮播图 start--%>
<div id="box_autoplay">
    <div class="list">
        <ul>
            <li><img src="client/ad/index_ad0.jpg" width="900px" height="335px" /></li>
            <li><img src="client/ad/index_ad1.jpg" width="900px" height="335px" /></li>
            <li><img src="client/ad/index_ad2.jpg" width="900px" height="335px" /></li>
            <li><img src="client/ad/index_ad3.jpg" width="900px" height="335px" /></li>
            <li><img src="client/ad/index_ad4.jpg" width="900px" height="335px" /></li>
            <li><img src="client/ad/index_ad5.jpg" width="900px" height="335px" /></li>
        </ul>
    </div>
</div>
<%--传智商城首页轮播图 end--%>
<%--4.公告板和本周热卖 start--%>
<div id="divcontent">
    <table width="900px" border="0" cellspacing="0">
        <tr>
            <td width="497">
                <img src="${pageContext.request.contextPath}/client/images/billboard.gif" width="497" height="38" />
                <table cellspacing="0" class="ctl">
                    <tr>
                        <td width="485" height="29">
                            尊敬的网上书城用户， 　　<br>
                            　　为了让大家有更好的购物体验，3月25日起，当日达业务关小黑屋回炉升级！<br>具体开放时间请留意公告，感谢大家的支持与理解，祝大家购物愉快！<br>
                            3月23日<br>
                            传智播客 网上书城系统管理部<br>
                        </td>
                    </tr>
                </table>
            </td>
            <td style="padding:5px 15px 10px 40px">
                <table width="100%" border="0" cellspacing="0">
                    <tr>
                        <td>
                            <img src="${pageContext.request.contextPath}/client/images/hottitle.gif" width="126" height="29" />
                        </td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0">
                    <tr>
                        <td style="width:80px; text-align:center">
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/client/bookcover/105.jpg" width="102" height="130" border="0" />
                            </a>
                            <br />
                        </td>
                        <td style="width:80px; text-align:center">
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/client/bookcover/106.jpg" width="102" height="130" border="0" />
                            </a>
                            <br />
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>

</div>
<%--公告板和本周热卖 end--%>
<%--5.传智书城底部 start--%>
<%@include file="foot.jsp"%>
<%--传智书城底部 end--%>
</body>
</html>
