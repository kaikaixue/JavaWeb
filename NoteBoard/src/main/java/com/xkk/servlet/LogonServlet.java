package com.xkk.servlet;

import com.xkk.bean.DTO.LogonDTO;
import com.xkk.mapper.UserMapper;
import com.xkk.util.MySessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "logon", urlPatterns = "/logon")
public class LogonServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SqlSession sqlSession = MySessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        LogonDTO logonDTO = LogonDTO.builder()
                .account(request.getParameter("account"))
                .password(request.getParameter("password"))
                .email(request.getParameter("email"))
                .flag(Integer.parseInt(request.getParameter("flag")))
                .avatar(request.getParameter("image"))
                .build();
        userMapper.logon(logonDTO);
        sqlSession.commit();
        response.sendRedirect("/NoteBoard/view/login.jsp");
    }
}
