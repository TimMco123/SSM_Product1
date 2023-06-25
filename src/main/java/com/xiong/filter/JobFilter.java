package com.xiong.filter;

import com.xiong.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration("jobFilter")
public class JobFilter implements Filter {
    @Autowired
    private JobService jobService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----JobFilter----init----");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("----JobFilter----doFilter----");
        request.setAttribute("jobList",jobService.getAllJob());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
