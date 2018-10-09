package com.carbroker.Filter;

import com.carbroker.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ForAdminFilter")
public class ForAdminFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws java.io.IOException, ServletException {



        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        User user = (User) req.getSession().getAttribute("user");

        if(user==null){
            RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
            rd.include(req, res);
        }
        if((!user.getRole().equals("admin"))){


            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.include(req, res);
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}