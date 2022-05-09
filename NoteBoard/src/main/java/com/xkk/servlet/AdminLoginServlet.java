package com.xkk.servlet;

import com.xkk.bean.DO.LoginDO;
import com.xkk.bean.DO.LoginsDO;
import com.xkk.bean.DTO.LoginDTO;
import com.xkk.bean.DTO.UpdateActiveDTO;
import com.xkk.mapper.UserMapper;
import com.xkk.util.MySessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminLogin", urlPatterns = {"/adminLogin"})
public class AdminLoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        if (!request.getParameter("code").equals(request.getSession().getAttribute("code"))) {
            response.sendRedirect("/NoteBoard/admin/login.jsp?msg=验证码错误");
            return;
        }

        String account = request.getParameter("account");
        String password = request.getParameter("password");

        if (!account.equals("admin")  || !password.equals("admin")) {
            response.sendRedirect("/NoteBoard/admin/login.jsp?msg=账号密码错误");
            return;
        }

        SqlSession sqlSession = MySessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        LoginDTO loginDTO = LoginDTO.builder()
                .account(request.getParameter("account"))
                .password(request.getParameter("password"))
                .build();

        LoginDO loginDO = userMapper.login(loginDTO);
        request.getSession().setAttribute("name", loginDO.getName());
        request.getSession().setAttribute("id", loginDO.getId());

        UpdateActiveDTO updateActiveDTO = UpdateActiveDTO.builder()
                .id(loginDO.getId())
                .active(1)
                .build();
        userMapper.updateActive(updateActiveDTO);
        sqlSession.commit();


        response.sendRedirect("/NoteBoard/admin/login_success.jsp?name=" + account);
    }
}
