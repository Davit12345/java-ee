package com.carbroker.controller;

import com.carbroker.Util.CryptWithMD5;
import com.carbroker.Util.GenerateRandomValue;
import com.carbroker.Util.MailSender;
import com.carbroker.Util.Validation;
import com.carbroker.dao.UserDao;
import com.carbroker.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletRegister")
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String firstname= request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        int age=Integer.parseInt(request.getParameter("age"));
        GenerateRandomValue gen=new GenerateRandomValue();
        String validationcod=  gen.generate();
       String hashpass= CryptWithMD5.cryptWithMD5(password);
 User user =new User(email,hashpass,firstname,lastname,age,validationcod);
        UserDao userDao=new UserDao();
        String errMess="";
        String good="";
        if(Validation.isValid(email)){
            errMess="Email  error  email is emptty ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }else  if( Validation.isValid(password)){
            errMess="Password  error  password is emptty ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }else  if( Validation.isValid(firstname)){
            errMess="name  error  name is emptty ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("register.jsp").forward(request, response);        }
        else  if( Validation.isValid(lastname)){
            errMess="surname  error  surname is emptty ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("register.jsp").forward(request, response);        }
        else  if(age<18 || age>99|| Validation.isValid(request.getParameter("age"))){
            errMess="age must be 18-99 ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("register.jsp").forward(request, response);        }
        else if(  userDao.save(user)!=0){
            good="scsessful registration";
            request.setAttribute("good",good);
            //send gmail
            MailSender.send(user.getEmail(),"your code",user.getValidationcod());
            request.getRequestDispatcher("/EmailValidation.jsp").forward(request,response);


        }
        else  {
            errMess="You have mistake";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }


}
