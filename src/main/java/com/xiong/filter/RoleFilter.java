package com.xiong.filter;

import com.xiong.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration("roleFilter")
public class RoleFilter implements Filter {
    @Autowired
    private RoleService roleService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----RoleFilter----init----");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("----RoleFilter----doFilter----");
        request.setAttribute("roleList",roleService.getAllRole());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
