package com.carbroker.Filter;

import com.carbroker.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebFilter(filterName = "AuthenFilter")
public class AuthenFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws java.io.IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        User user = (User) req.getSession().getAttribute("user");
        String errMess="";


       if (user == null) {
            errMess="You have mistake";
    request.setAttribute("errMess",errMess);
    request.getRequestDispatcher("/Login.jsp").forward(request,response);

        }else if(user.getStatus()==2){
////    errMess="You are blocked plase connect whit me";
////    req.setAttribute("errMess",errMess);
//   RequestDispatcher rd = req.getRequestDispatcher("../Block.jsp");
            res.sendRedirect("/Block.jsp");

        }
        else  if(user.getStatus()==0){
            errMess="Plase validate email and  go Loging";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("/Login.jsp").forward(request,response);

        } else {
            chain.doFilter(request, response);
        }
    }
    public void init(FilterConfig config) throws ServletException {

    }

}
