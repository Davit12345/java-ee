package com.carbroker.controller.user;

import com.carbroker.dao.CarDao;
import com.carbroker.model.Car;
import com.carbroker.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletBuyCar")
public class ServletBuyCar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        CarDao carDao=new CarDao();
        Car car=carDao.getCarById(id);
        String errMsg="";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");


      ///
        if(user.getAmount()<car.getPrice()){
            errMsg="error you con not buy  car you dont have many ";
            request.setAttribute("errMsg", errMsg);
            request.getRequestDispatcher("/page/checkbuyCarmy/infoCar.jsp").forward(request, response);
        }
       else if(car.getUser_id()==user.getId()){
            errMsg="error you can not buy your car";
            request.setAttribute("errMsg", errMsg);
            request.getRequestDispatcher("/page/checkbuyCar/infoCar.jsp").forward(request, response);
        }else if(carDao.buyCar(user,car)>0){
            errMsg="you scusses buy Car";
            request.setAttribute("errMsg", errMsg);
            request.getRequestDispatcher("/page/myCar.jsp").forward(request, response);
        }

    }


}
