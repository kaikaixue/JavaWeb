package com.xkk.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "GuessLetter", urlPatterns = "/guessLetter")
public class GuessLetterServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=utf-8");
        Character tempCharacter = (Character) session.getAttribute("tempCharacter");
        String input = request.getParameter("input");
        if (input.charAt(0) < tempCharacter) {
            String url = "/Guess/view/inputLetter.jsp?result=" + "small";
            response.sendRedirect(url);
        } else if (input.charAt(0) > tempCharacter) {
            String url = "/Guess/view/inputLetter.jsp?result=" + "big";
            response.sendRedirect(url);
        } else {
            String url = "/Guess/view/inputLetter.jsp?result=" + "yes";
            response.sendRedirect(url);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}
