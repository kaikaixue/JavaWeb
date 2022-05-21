<%@ page import="com.xkk.bean.DO.UserDO" %>
<%@ page import="com.xkk.mapper.UserMapper" %>
<%@ page import="com.xkk.bean.DO.NoteDO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.xkk.mapper.NoteMapper" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.xkk.util.MySessionUtils" %>
<%@ page import="com.xkk.bean.DTO.NoteLikeListDTO" %>
<%@ page import="com.xkk.bean.DTO.NoteLikeSizeDTO" %>
<%@ page import="com.xkk.bean.DTO.AllNoteListDTO" %>
<%@ page import="com.xkk.bean.DTO.NoteLikeSizeDTO" %>
<%@ page import="com.xkk.bean.DTO.AllNoteListDTO" %>
<%@  page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function del(id) {
            location.assign("/NoteBoard/delNote?id=" + id)
        }

        function pagination(value) {
            location.assign("/NoteBoard/view/message.jsp?page1=" + value)
        }
    </script>
</head>
<body style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center">
<%
    SqlSession sqlSession= MySessionUtils.getSession();
    NoteMapper noteMapper = sqlSession.getMapper(NoteMapper.class);
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    if (session.getAttribute("id") == null) {
        // 权限拦截
        response.sendRedirect("/NoteBoard/view/login.jsp");
        return;
    }

    Integer page1 = 0;
    Integer pageSize = 2;

    if (request.getParameter("page1") != null) {
        page1 = Integer.valueOf(request.getParameter("page1"));
    }

    UserDO userDO =userMapper.getInfo((Integer) session.getAttribute("id"));
%>
<div style="display: flex">
    <form action="/NoteBoard/uploadServlet" method="post" enctype="multipart/form-data">
        <input type="file" name="myFile">
        <input type="submit" value="上传">
    </form>
    <img src="<%out.print(userDO.getImage());%> " width="40px" height="40px" />
    <h1>留言板 <a href="/NoteBoard/view/logout.jsp">退出登录</a></h1>
</div>
<h1>
    <a href="/NoteBoard/view/message.jsp?page1=0">显示所有留言</a>
</h1>
<div style="display: flex">
    在
    <form method="get" action="">
        <select name="search">
            <option value="1" selected>标题</option>
            <option value="2">作者</option>
            <option value="3">内容</option>
        </select>
        中查询:
        <input type="text" name="text" />
        <input type="submit" value="搜索"/>
    </form>
</div>
<h1><a href="/NoteBoard/view/addNote.jsp">添加新留言</a></h1>
<table border="1">
    <tr>
        <td> 留言ID </td>
        <td> 标题 </td>
        <td> 作者 </td>
        <td> 内容 </td>
        <td> 删除 </td>
    </tr>
    <%
        Long total = null;
        List<NoteDO> noteListDOList = null;
        String search = null;
        String searchPath = "";
        if (request.getParameter("search") != null) {
            switch (request.getParameter("search")) {
                case "1":
                    search = "title";
                    break;
                case "2":
                    search = "author";
                    break;
                case "3":
                    search = "content";
                    break;
            }

            NoteLikeListDTO noteLikeListDTO = NoteLikeListDTO.builder()
                    .like(search)
                    .parameter(request.getParameter("text"))
                    .page(page1 * pageSize)
                    .pageSize(pageSize)
                    .build();

            noteListDOList = noteMapper.getNodeLikeList(noteLikeListDTO);

            NoteLikeSizeDTO noteLikeSizeDTO = NoteLikeSizeDTO.builder()
                    .like(search)
                    .parameter(request.getParameter("text"))
                    .build();

            total = noteMapper.getNoteLikeSize(noteLikeSizeDTO).getTotal();

            searchPath = "&search=" + request.getParameter("search") + "&text=" + request.getParameter("text");
        } else {

            AllNoteListDTO allNoteListDTO = AllNoteListDTO.builder()
                    .page(page1 * pageSize)
                    .pageSize(pageSize)
                    .build();

            noteListDOList = noteMapper.getAllNoteList(allNoteListDTO);

            total = noteMapper.getAllNoteSize().getTotal();
        }

        total = total / pageSize + ((((total * 1.0 / pageSize) -  total / pageSize) > 0) ? 0 : -1);

        String temp = "";
        for (NoteDO noteDO : noteListDOList) {
            temp +=
                    "<tr><td>" + noteDO.getId() + "</td>" +
                    "<td>" + noteDO.getTitle() + "</td>" +
                    "<td>" + noteDO.getAuthor() + "</td>" +
                    "<td>" + noteDO.getContent() + "</td>" +
                    "<td><a href=\"/NoteBoard/view/updateNote.jsp?id=" + noteDO.getId() + "\">更新</a> |<span onclick=del(" + noteDO.getId() + ")>删除</span></td></tr>";
        }

        out.print(temp);
    %>
    <tr>
        <td colspan="5">
            <a href="/NoteBoard/view/message.jsp?page1=0<%out.print(searchPath);%>">首页</a>
            <a href="/NoteBoard/view/message.jsp?page1=<%out.print(page1 - 1 <= 0 ? 0 : page1 - 1); out.print(searchPath);%>">上一页</a>
            <a href="/NoteBoard/view/message.jsp?page1=<%out.print(page1 + 1 >= total ? total : page1 + 1); out.print(searchPath);%>">下一页</a>
            <a href="/NoteBoard/view/message.jsp?page1=<%out.print(total); out.print(searchPath);%>">最后页</a>
            <select onchange="pagination(value)">
                <%
                    temp = "";
                    for (int i = 0; i <= total; i++) {
                        String selected = "";

                        if (i == page1) {
                            selected = "selected";
                        }

                        temp += "<option value='" + i + "'" + selected + ">" + (i + 1) + "/" + (total + 1) + "</option>";
                    }
                    out.print(temp);
                %>
            </select>
        </td>
    </tr>
</table>
</body>
</html>
