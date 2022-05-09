package com.xkk.controller;

import com.xkk.domain.DO.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "cart", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 变量 cart 引用用户的购物车
        List<Book> cart = null;
        // 变量pruFlag标记用户是否买过商品
        boolean purFlag = true;
        // 获得用户的session
        HttpSession session = request.getSession(false);
        // 如果session为null，purFlag置为false
        if (session == null) {
            purFlag = false;
        } else {
            // 获得用户购物车
            cart = (List<Book>) session.getAttribute("cart");
            // 如果用的购物车为null，pruFlag置为false
            if (cart == null) {
                purFlag = false;
            }
        }
        // 如果purFlag为false，表用用户没有购买图书 重定向到listServlet页面
        if (!purFlag) {
            out.write("对不起，你还没有购买任何商品<br/>");
        } else {
            // 否则显示用户购买图书信息
            out.write("你购买的图书有: <br/>");
            double price = 0;
            for (Book book : cart) {
                out.write(book.getName() + "<br/>");
            }
        }
    }
}
