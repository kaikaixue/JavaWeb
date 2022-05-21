package com.xkk.servlet;

import com.xkk.bean.DTO.UpdateNoteDTO;
import com.xkk.mapper.NoteMapper;
import com.xkk.util.MySessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateNoteServlet", urlPatterns = "/updateNote")
public class UpdateNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSession sqlSession = MySessionUtils.getSession();
        NoteMapper noteMapper = sqlSession.getMapper(NoteMapper.class);
        UpdateNoteDTO updateNoteDTO = UpdateNoteDTO.builder()
                .id(Integer.valueOf(req.getParameter("id")))
                .author(req.getParameter("author"))
                .title(req.getParameter("title"))
                .content(req.getParameter("content"))
                .build();
        noteMapper.updateNote(
                updateNoteDTO
        );
        sqlSession.commit();
        resp.sendRedirect("/NoteBoard/view/message.jsp");
    }
}