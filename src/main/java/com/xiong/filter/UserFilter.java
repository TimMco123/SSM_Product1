package com.xiong.filter;

import com.xiong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration("userFilter")
public class UserFilter implements Filter {
    @Autowired
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----UserFilter----init----");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("----UserFilter----doFilter----");
        request.setAttribute("userList", userService.getAllUser1());//查User表，单表查询
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
