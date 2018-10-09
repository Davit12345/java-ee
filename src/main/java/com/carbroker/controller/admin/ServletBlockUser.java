package com.carbroker.controller.admin;

import com.carbroker.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletBlockUser")
public class ServletBlockUser extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();

        if (userDao.BlockUserwhitproduct(id) > 0) {
            request.getRequestDispatcher("/admin/ListforUser.jsp").forward(request, response);
            request.setAttribute("msg", msg);
            msg = "you delete the User  sucsses ";
        } else {
            request.getRequestDispatcher("/admin/ListforUser.jsp").forward(request, response);
            request.setAttribute("msg", msg);
            msg = "tere are error ";
        }

    }
}
