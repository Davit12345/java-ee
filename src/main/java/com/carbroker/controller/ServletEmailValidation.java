package com.carbroker.controller;

import com.carbroker.Util.Validation;
import com.carbroker.dao.UserDao;
import com.carbroker.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletEmailValidation")
public class ServletEmailValidation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String validationcod=request.getParameter("validationcod");
        String errMess="";String good="";
UserDao userDao=new UserDao();
User user=new User();
user=userDao.checkValid(email,validationcod);

        if(Validation.isValid(email)){
            errMess="Email  error  email is emptty ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("EmailValidation.jsp").forward(request, response);
        }else  if( Validation.isValid(validationcod)){
            errMess="Password  error  password is emptty ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("/EmailValidation.jsp").forward(request, response);
        }else  if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.setAttribute("good",good);
            request.getRequestDispatcher("/page/home.jsp").forward(request, response);
}else{

                errMess="You have mistake";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("/EmailValidation.jsp").forward(request, response);
}



    }


}
