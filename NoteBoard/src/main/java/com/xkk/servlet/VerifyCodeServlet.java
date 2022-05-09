package com.xkk.servlet;

import com.xkk.util.VerifyCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "verifyCode", urlPatterns = "/verifyCode")
public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VerifyCodeUtil verifyCode = new VerifyCodeUtil();
        BufferedImage bufferedImage = verifyCode.getImage();
        String text = verifyCode.getText();
        req.getSession().setAttribute("code", text);
        VerifyCodeUtil.output(bufferedImage, resp.getOutputStream());
    }
}
