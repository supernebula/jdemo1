package com.essg.web.manage.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义Filter
 * Spring Boot实战：拦截器与过滤器, https://www.cnblogs.com/paddix/p/8365558.html
 * 例，过滤器汇总的Filter
 */
public class AuthTokenFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
