package com.xkk.servlet;

import com.xkk.mapper.NoteMapper;
import com.xkk.mapper.UserMapper;
import com.xkk.util.MySessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delUser", urlPatterns = "/delUser")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSession sqlSession = MySessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.delUser(Integer.valueOf(req.getParameter("id")));
        sqlSession.commit();
        resp.sendRedirect("/NoteBoard/admin/userManager.jsp");
    }
}
