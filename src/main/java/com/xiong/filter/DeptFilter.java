package com.xiong.filter;

import com.xiong.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration("deptFilter")
public class DeptFilter implements Filter {
    @Autowired
    private DeptService deptService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----DeptFilter----init----");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("----DeptFilter----doFilter----");
        request.setAttribute("deptList",deptService.getAllDept());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
