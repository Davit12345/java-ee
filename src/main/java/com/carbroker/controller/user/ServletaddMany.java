package com.carbroker.controller.user;

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

@WebServlet(name = "ServletaddMany")
public class ServletaddMany extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Double many=Double.parseDouble(request.getParameter("many"));
        String errMess="";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        UserDao userDao=new UserDao();
        if( many>0){
            errMess="You sucsses add many";
            userDao.addMany(user.getEmail(),many);
            response.sendRedirect("/page/addMany.jsp");
        }
        else{

            errMess="not good writen amount";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("/page/addMany.jsp").forward(request,response);
        }
    }


}
