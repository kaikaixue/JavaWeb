package com.xkk.servlet;

import com.xkk.JavaBean.User;
import com.xkk.dao.LoginDao;
import com.xkk.dao.impl.LoginDaoImpl;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "login", urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {
    @SneakyThrows
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        LoginDao loginDao = new LoginDaoImpl();
        int result = loginDao.login(user);
        if (result > 0) {
            response.sendRedirect("/review/view/success.jsp?username="  + username);
        } else {
            response.sendRedirect("/review/view/login.jsp");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        this.doPost(request, response);
    }
}
