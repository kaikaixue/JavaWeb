package com.xkk.servlet;

import com.xkk.bean.DTO.AddNoteDTO;
import com.xkk.mapper.NoteMapper;
import com.xkk.util.MySessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addNote", urlPatterns = "/addNote")
public class AddNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSession sqlSession= MySessionUtils.getSession();
        System.out.println(req.getSession().getAttribute("name"));

        NoteMapper noteMapper = sqlSession.getMapper(NoteMapper.class);
        AddNoteDTO addNoteDTO = AddNoteDTO.builder()
                .title(req.getParameter("title"))
                .author((String)req.getSession().getAttribute("name"))
                .content(req.getParameter("content"))
                .build();
        Integer result = noteMapper.addNote(addNoteDTO);
        sqlSession.commit();
        resp.sendRedirect("/NoteBoard/view/message.jsp");
    }
}
