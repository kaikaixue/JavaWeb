package com.xkk.servlet;

import com.xkk.JavaBean.RegisterUser;
import com.xkk.dao.RegisterDao;
import com.xkk.dao.impl.RegisterDaoImpl;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Register", urlPatterns = {"/registerServlet"})
public class RegisterServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        RegisterUser registerUser = new RegisterUser(username, password, email);
        RegisterDao registerDao = new RegisterDaoImpl();
        int result = 0;
        try {
            result = registerDao.register(registerUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (result > 0) {
            response.sendRedirect("/review/view/login.jsp");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }
}
