<%@ page import="com.xkk.domain.DO.UserDO" %>
<%@ page import="com.xkk.mapper.UserMapper" %>
<%@ page import="com.xkk.domain.DO.NoteDO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.xkk.mapper.NoteMapper" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.xkk.util.MySessionUtils" %>
<%@ page import="com.xkk.domain.DTO.NoteLikeListDTO" %>
<%@ page import="com.xkk.domain.DTO.NoteLikeSizeDTO" %>
<%@ page import="com.xkk.domain.DTO.AllNoteListDTO" %>
<%@ page import="com.xkk.domain.DTO.NoteLikeSizeDTO" %>
<%@ page import="com.xkk.domain.DTO.AllNoteListDTO" %>
<%@ page import="com.xkk.domain.DO.NoteTotalDO" %>
<%@  page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function del(id) {
            location.assign("/Notes/delNote?id=" + id)
        }

        function pagination(value) {
            location.assign("/Notes/view/message.jsp?page1=" + value)
        }
    </script>
</head>
<body style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center">
<%
    SqlSession sqlSession= MySessionUtils.getSession();
    if (session.getAttribute("id") == null) {
        // 权限拦截
        response.sendRedirect("/Notes/view/login.jsp");
        return;
    }

    Integer page1 = 0;
    Integer pageSize = 2;

    if (request.getParameter("page1") != null) {
        page1 = Integer.valueOf(request.getParameter("page1"));
    }

    UserDO userDO = sqlSession.selectOne("com.xkk.mapper.UserMapper.getInfo",(Integer) session.getAttribute("id"));
%>
<div style="display: flex">
    <img src="<%out.print(userDO.getImage());%>" />
    <h1>留言板 <a href="/Notes/view/logout.jsp">退出登录</a></h1>
</div>
<h1>
    <a href="/Notes/view/message.jsp?page1=0">显示所有留言</a>
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
<h1><a href="/Notes/view/addNote.jsp">添加新留言</a></h1>
<table border="1">
    <tr>
        <td> 留言ID </td>
        <td> 标题 </td>
        <td> 作者 </td>
        <td> 内容 </td>
        <td> 删除 </td>
    </tr>
    <%
//        SqlSession sqlSession1= MySessionUtils.getSession();
        Integer total = 0;
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

            noteListDOList = sqlSession.selectList("com.xkk.mapper.NoteMapper.getNoteLikeList", noteLikeListDTO);

            NoteLikeSizeDTO noteLikeSizeDTO = NoteLikeSizeDTO.builder()
                    .like(search)
                    .parameter(request.getParameter("text"))
                    .build();

            total = sqlSession.selectOne("com.xkk.mapper.NoteMapper.getNoteLikeSize", noteLikeSizeDTO);

            searchPath = "&search=" + request.getParameter("search") + "&text=" + request.getParameter("text");
        } else {

            AllNoteListDTO allNoteListDTO = AllNoteListDTO.builder()
                    .page(page1 * pageSize)
                    .pageSize(pageSize)
                    .build();

            noteListDOList = sqlSession.selectList("com.xkk.mapper.NoteMapper.getAllNoteList", allNoteListDTO);
            NoteTotalDO noteTotalDO = sqlSession.selectOne("com.xkk.mapper.NoteMapper.getAllNoteSize");
            total = noteTotalDO.getTotal();
        }

        total = total / pageSize + ((((total * 1.0 / pageSize) -  total / pageSize) > 0) ? 0 : -1);

        String temp = "";
        for (NoteDO noteDO : noteListDOList) {
            temp +=
                    "<tr><td>" + noteDO.getId() + "</td>" +
                    "<td>" + noteDO.getTitle() + "</td>" +
                    "<td>" + noteDO.getAuthor() + "</td>" +
                    "<td>" + noteDO.getContent() + "</td>" +
                    "<td><span onclick=del(" + noteDO.getId() + ")>删除</span></td></tr>";
        }

        out.print(temp);
    %>
    <tr>
        <td colspan="5">
            <a href="/Notes/view/message.jsp?page1=0<%out.print(searchPath);%>">首页</a>
            <a href="/Notes/view/message.jsp?page1=<%out.print(page1 - 1 <= 0 ? 0 : page1 - 1); out.print(searchPath);%>">上一页</a>
            <a href="/Notes/view/message.jsp?page1=<%out.print(page1 + 1 >= total ? total : page1 + 1); out.print(searchPath);%>">下一页</a>
            <a href="/Notes/view/message.jsp?page1=<%out.print(total); out.print(searchPath);%>">最后页</a>
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
