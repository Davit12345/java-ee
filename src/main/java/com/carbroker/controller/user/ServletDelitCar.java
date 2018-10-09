package com.carbroker.controller.user;

import com.carbroker.dao.CarDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDelitCar")
public class ServletDelitCar extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String errMsg = "";
        int id = Integer.parseInt(request.getParameter("id"));
        CarDao carDao=new CarDao();
        if (carDao.deletCar(id) > 0) {
            errMsg = "you delete the Car  sucsses ";
            request.setAttribute("errMsg", errMsg);
            request.getRequestDispatcher("/page/myCar.jsp").forward(request, response);

        } else {
            errMsg = "tere are error ";
            request.setAttribute("errMsg", errMsg);
            request.getRequestDispatcher("/page/myCar.jsp").forward(request, response);

        }
    }


}
