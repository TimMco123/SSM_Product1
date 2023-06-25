package com.xiong.filter;

import com.xiong.service.Job_levelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration("job_levelFilter")
public class Job_levelFilter implements Filter {
    @Autowired
    private Job_levelService job_levelService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----Job_levelFilter----init----");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("----Job_levelFilter----doFilter");
        request.setAttribute("job_levelList", job_levelService.getAll());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
