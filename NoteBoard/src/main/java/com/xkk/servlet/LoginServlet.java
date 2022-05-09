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

@WebServlet(name = "noteLogin", urlPatterns = "/noteLogin")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        SqlSession sqlSession= MySessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        if (!request.getParameter("code").equals(request.getSession().getAttribute("code"))) {
            response.sendRedirect("/NoteBoard/view/login.jsp?msg=验证码错误");
            return;
        }

        LoginDTO loginDTO = LoginDTO.builder()
                .account(request.getParameter("account"))
                .password(request.getParameter("password"))
                .build();

        LoginDO loginDO = userMapper.login(loginDTO);

        if (loginDO == null) {
            response.sendRedirect("/NoteBoard/view/login.jsp?msg=账号密码错误");
            return;
        }

        request.getSession().setAttribute("name", loginDO.getName());
        request.getSession().setAttribute("id", loginDO.getId());
        UpdateActiveDTO updateActiveDTO = UpdateActiveDTO.builder()
                .id(loginDO.getId())
                .active(1)
                .build();
        userMapper.updateActive(updateActiveDTO);
        sqlSession.commit();
        LoginsDO loginsDO = userMapper.logins();
        response.sendRedirect("/NoteBoard/view/success.jsp?name=" + loginDO.getName() + "&logins=" + loginsDO.getNumber());
    }
}
