package com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionFilter implements Filter {
    FilterConfig config;
    List exceptionPage;
    private static final Logger logger = LoggerFactory.getLogger(SessionFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        exceptionPage = new ArrayList();
        exceptionPage.add("/login");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        StringBuilder basePath = new StringBuilder();
        basePath.append(httpRequest.getScheme());
        basePath.append("://");
        basePath.append(httpRequest.getServerName());
        basePath.append(":");
        basePath.append(httpRequest.getServerPort());
        basePath.append(httpRequest.getContextPath());
        basePath.append("/");
        String requestURL = httpRequest.getRequestURL().toString();
        HttpSession session = httpRequest.getSession();
        logger.info("SESSION : "+session.getAttribute("USER"));
        if (session.getAttribute("USER")==null) {
            String exceptURL = null;
            int exceptSize = getExceptionPage().size();
            for (int i = 0; i < exceptSize; i++) {
                exceptURL = (String) getExceptionPage().get(i);
                if (requestURL.contains(exceptURL)) {
                    chain.doFilter(request, response);
                    return;
                }
            }
            logger.info("basePath : "+basePath.toString());
            httpResponse.sendRedirect(basePath.toString() + "login");
            return;
        }
        chain.doFilter(request, response);
    }
    public FilterConfig getConfig() {
        return config;
    }
    public void setConfig(FilterConfig config) {
        this.config = config;
    }
    public List getExceptionPage() {
        return exceptionPage;
    }
    public void setExceptionPage(List exceptionPage) {
        this.exceptionPage = exceptionPage;
    }
    @Override
    public void destroy() {
    }
}
