package com.xkk.servlet;

import com.xkk.bean.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "studentServlet", urlPatterns = {"/studentServlet"})
public class StudentServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = Student.builder()
                .name("张三")
                .mobile("1000000")
                .build();
        request.getSession().setAttribute("student", student);

        response.sendRedirect("/NoteBoard/view/elBean.jsp");
    }
}
