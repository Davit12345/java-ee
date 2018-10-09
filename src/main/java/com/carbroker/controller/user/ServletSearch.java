package com.carbroker.controller.user;

import com.carbroker.Util.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletSearch")
public class ServletSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String good="";
        String searchname=request.getParameter("searchname");


        if(Validation.isValid(searchname)){
            good="See  All  Car ";
            request.setAttribute("good",good);
            request.getRequestDispatcher("/page/home.jsp").forward(request,response);
        }
        else{

            request.getRequestDispatcher("/page/home.jsp").forward(request, response);
            request.setAttribute("good",good);
        }

    }
}
