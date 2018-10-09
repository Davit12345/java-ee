package com.carbroker.controller;

import com.carbroker.dao.UserDao;
import com.carbroker.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ServletWlcome")
public class ServletWlcome extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User sessionUser = (User) request.getSession().getAttribute("user");
        if (sessionUser != null){
            response.sendRedirect("/page/home.jsp");
            return;
        }

        String email = null;
        String password = null;

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie: cookies) {

            if(cookie.getName().equals("login")){

                email = cookie.getValue();
                System.out.println(email);
            }
            if(cookie.getName().equals("pass")){
                password = cookie.getValue();
            }


        }

        if(email==null ){
            response.sendRedirect("/Login.jsp");

        }
        else{
            UserDao userDao = new UserDao();
            User user = userDao.checklogin(email,password);
            if(user != null){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("/page/home.jsp");
            }
        }
    }
}
