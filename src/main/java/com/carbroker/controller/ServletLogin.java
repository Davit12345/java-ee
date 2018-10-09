package com.carbroker.controller;

import com.carbroker.Util.CryptWithMD5;
import com.carbroker.Util.Validation;
import com.carbroker.dao.UserDao;
import com.carbroker.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String remember = request.getParameter("remmember");

        String hashpass= CryptWithMD5.cryptWithMD5(password);
        if(remember==null){
            remember="off";
        }

        String errMess="";

        UserDao userDao=new UserDao();
        User user=null;
        user=userDao.checklogin(email,password);/////////->MD5
        if(Validation.isValid(email)){
            errMess="Email  error  email is emptty ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("/Login.jsp").forward(request,response);
        }else  if( Validation.isValid(password)){
            errMess="Password  error  password is emptty ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("/Login.jsp").forward(request,response);
        }
        else if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            System.out.println(remember.equals("on"));

            if( remember.equals("on")){
                Cookie cookie = new Cookie("login",user.getEmail());
                Cookie cookie1 = new Cookie("pass",user.getPassword());
                response.addCookie(cookie);
                response.addCookie(cookie1);
            }
           // request.getRequestDispatcher("/page/home.jsp").forward(request,response);
         response.sendRedirect("/page/home.jsp");
        }
        else{
            errMess="Password error";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("/Login.jsp").forward(request,response);

        }
    }
}