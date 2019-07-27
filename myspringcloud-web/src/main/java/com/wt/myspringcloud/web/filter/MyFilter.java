package com.wt.myspringcloud.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author 文通
 * @since 2019/7/21
 */
@WebFilter(urlPatterns = "/*", initParams = {@WebInitParam(name = "mood", value = "awake")})
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }
}
