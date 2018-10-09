package com.carbroker.controller.admin;

import com.carbroker.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletAdmin")
public class ServletAdmin extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if(user.getRole().equals("admin")){
            request.getRequestDispatcher("/admin/admin.jsp").forward(request,response);
        }else{
            //filtr solution   this  problem
             request.getRequestDispatcher("/error.jsp").forward(request,response);
        }

    }
}