package com.xiong.filter;

import com.xiong.service.RPTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration("rpTypeFilter")
public class RPTypeFilter implements Filter {
    @Autowired
    private RPTypeService rpTypeService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----RPTypeFilter----init----");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("----RPTypeFilter----doFilter----");
        request.setAttribute("rpTypeList", rpTypeService.getAllRPT());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
