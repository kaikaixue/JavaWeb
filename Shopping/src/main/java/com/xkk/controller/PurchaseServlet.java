package com.xkk.controller;

import com.xkk.domain.DO.Book;
import com.xkk.mapper.BookDB;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "purchase", urlPatterns = "/purchase")
public class PurchaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取用户购买的商品
        String id = request.getParameter("id");
        if (id == null) {
            // 如果id 为null，重定向到ListBookServlet页面
            String url = "/Shopping/listBook";
            response.sendRedirect(url);
            return;
        }
        Book book = BookDB.getBook(id);

        // 创建或者获得用户的session对象
        HttpSession session = request.getSession();
        // 从Session对象中获得用户购物车
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart == null) {
            // 首次购买，为用户创建一个购物车（List集合模拟购物车）
            cart = new ArrayList<>();
            // 将购物车存入Session对象
            session.setAttribute("cart", cart);
        }
        // 将商品放入购物车
        cart.add(book);
        // 创建Cookie存放session的标识号
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60 * 30);
        cookie.setPath("/");
        response.addCookie(cookie);
        // 重定向到购物车页面
        String url = "/Shopping/cart";
        String newUrl = response.encodeRedirectURL(url);
        response.sendRedirect(newUrl);
    }
}
