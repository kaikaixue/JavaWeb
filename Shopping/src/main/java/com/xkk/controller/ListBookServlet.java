package com.xkk.controller;

import com.xkk.domain.DO.Book;
import com.xkk.mapper.BookDB;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "listBook", urlPatterns = "/listBook")
public class ListBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        Collection<Book> books = BookDB.getAll();
        out.write("本站提供的图书有：<br />");
        for (Book book : books) {
            String url = "/Shopping/purchase?id=" + book.getId();
            HttpSession s = request.getSession();
            String newUrl = response.encodeRedirectURL(url);
            out.write(book.getName() + "<a href='" + newUrl + "'>点击购买<a/><br/>");
        }
    }
}
