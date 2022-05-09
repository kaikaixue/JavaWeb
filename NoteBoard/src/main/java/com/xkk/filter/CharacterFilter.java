package com.xkk.filter;

import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebFilter
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 拦截所有请求，解决中文乱码
        // 指定request和response编码
        request.setCharacterEncoding("utf-8");  // 只对消息体有效
        response.setContentType("text/html;charset=utf-8");
        // 对request进行包装
        CharacterRequest characterRequest = new CharacterRequest(request);
        filterChain.doFilter(characterRequest, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

class CharacterRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    public CharacterRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @SneakyThrows
    public String getParameter(String name) {
        // 调用被包装对象的getParameter方法，获得请求参数
        String value = super.getParameter(name);
        if (value == null) {
            return null;
        }
        // 判断请求方式
        String method = super.getMethod();
        if ("get".equalsIgnoreCase(method)) {
            try {
                value = new String(value.getBytes("iso-8859-1"), "utf-8");
            } catch (UnsupportedClassVersionError e) {
                throw new RuntimeException(e);
            }
        }
        return value;
    }
}
