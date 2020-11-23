package com.example.demoCrud.logging;
import java.io.IOException;
//import java.util.logging.Filter;
//import java.util.logging.LogRecord;
//import java.util.logging.LogRecord;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import ch.qos.logback.classic.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class LoggingFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // Start time
        long time = System.currentTimeMillis();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //Request Logger
        LOGGER.info("\nRequest Header :\n\nMethod: {}\nRequest URL: {}\nRequest URI: {}\nQuery String: {}\n",request.getMethod(),request.getRequestURL(),request.getRequestURI(),request.getQueryString());

        //Response Logger
        response.addDateHeader("Date",1000);
        response.addHeader("Custom Header","This is Custom Header.");
        LOGGER.info("\nResponse Header :\n\nStatus Code: {}\nContent-Type: {}\nLocale: {}\nDate: {}\nCustom Header: {}\n",response.getStatus(),response.getContentType(),response.getLocale(),response.getHeader("Date"),response.getHeader("Custom Header"));

        //Calling FilterChain
        filterChain.doFilter(servletRequest,servletResponse);

        // End Time
        time=System.currentTimeMillis() - time;

        //Response Time
        LOGGER.info("\n\nResponse Time: {}ms\n",time);
    }

}