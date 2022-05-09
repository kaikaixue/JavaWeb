<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.xkk.util.MySessionUtils" %>
<%@ page import="com.xkk.mapper.UserMapper" %>
<%@ page import="java.util.List" %>
<%@ page import="com.xkk.bean.DO.UserListDO" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/5/9
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function del(id) {
            location.assign("/NoteBoard/delUser?id=" + id)
        }

        function pagination(value) {
            location.assign("/mb/page/admin/manageUser.jsp?page1=" + value)
        }
    </script>
</head>
<body style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center">
<%
//    if (session.getAttribute("id") == null) {
//        // 权限拦截
//        response.sendRedirect("/NoteBoard/view/login.jsp");
//        return;
//    }

    Integer page1 = 0;
    Integer pageSize = 2;

    if (request.getParameter("page1") != null) {
        page1 = Integer.valueOf(request.getParameter("page1"));
    }

//    UserDO userDO = ApiConstant.userMapper.userInfo((Integer) session.getAttribute("id"));
%>
<div style="display: flex">
    <h1>留言板用户管理系统 <a href="/NoteBoard/admin/logout.jsp">退出登录</a></h1>
</div>
<div>
<%--    <%out.print(((HashMap)session.getAttribute("usernames")).size());%>--%>
    当前在线用户：
    <%
        SqlSession sqlSession = MySessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<String> nameList = userMapper.findActive();
        for (String name : nameList) {
            out.print(name + "  ");
        }
    %>
</div>
<h1>
    <p>用户管理</p>
</h1>
<table border="1">
    <tr>
        <td> 用户ID </td>
        <td> 用户名 </td>
        <td> Email </td>
        <td> 用户类别 </td>
        <td> 删除 </td>
    </tr>
    <%
//        Long total = ApiConstant.userMapper.getAllUsersTotal().getTotal();
        List<UserListDO> userList =  userMapper.findAllUser();
//        List<UserDO> userDOS = ApiConstant.userMapper.getAllUsers(page1, pageSize);

//        total = total / pageSize + ((((total * 1.0 / pageSize) -  total / pageSize) > 0) ? 0 : -1);

        String temp = "";
        for (UserListDO userDO1 : userList) {
            temp +=
                    "<tr><td>" + userDO1.getUserId() + "</td>" +
                            "<td>" + userDO1.getName() + "</td>" +
                            "<td>" + userDO1.getEmail() + "</td>" +
                            "<td>" + (userDO1.getFlag().equals("0") ? "管理员" : "普通用户") + "</td>" +
                            "<td><span onclick=del(" + userDO1.getUserId() + ")>删除</span></td></tr>";
        }

        out.print(temp);
    %>
<%--    <tr>--%>
<%--        <td colspan="5">--%>
<%--            <a href="/mb/page/message.jsp?page1=0">首页</a>--%>
<%--            <a href="/mb/page/message.jsp?page1=<%out.print(page1 - 1 <= 0 ? 0 : page1 - 1);%>">上一页</a>--%>
<%--            <a href="/mb/page/message.jsp?page1=<%out.print(page1 + 1 >= total ? total : page1 + 1);%>">下一页</a>--%>
<%--            <a href="/mb/page/message.jsp?page1=<%out.print(total);%>">最后页</a>--%>
<%--            <select onchange="pagination(value)">--%>
<%--                <%--%>
<%--                    temp = "";--%>
<%--                    for (int i = 0; i <= total; i++) {--%>
<%--                        String selected = "";--%>

<%--                        if (i == page1) {--%>
<%--                            selected = "selected";--%>
<%--                        }--%>

<%--                        temp += "<option value='" + i + "'" + selected + ">" + (i + 1) + "/" + (total + 1) + "</option>";--%>
<%--                    }--%>
<%--                    out.print(temp);--%>
<%--                %>--%>
<%--            </select>--%>
<%--        </td>--%>
<%--    </tr>--%>
</table>
</body>
</html>
