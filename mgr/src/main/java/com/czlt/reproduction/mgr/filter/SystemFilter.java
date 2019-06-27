package com.czlt.reproduction.mgr.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class SystemFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // CORS
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        rep.setHeader("Access-Control-Allow-Origin", "*");
        rep.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        rep.setHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Content-Type, x-client-no-encrypt, X-Auth-Token");
        rep.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        chain.doFilter(req, rep);
    }

    @Override
    public void destroy() {

    }
}
