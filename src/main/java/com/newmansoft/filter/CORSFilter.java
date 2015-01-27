package com.newmansoft.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andyn on 1/26/2015.
 */
public class CORSFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String origin = httpServletRequest.getHeader("Origin");

        httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        if(httpServletRequest.getMethod().equalsIgnoreCase("OPTIONS")) {
            httpServletResponse.setHeader("Access-Control-Allowed-Methods", "POST, GET, PUT, OPTIONS");
            httpServletResponse.setHeader("Access-Control-Max-Age", "604800");
            return;
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
