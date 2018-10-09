package com.carbroker.controller.user;

import com.carbroker.Util.Validation;
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

@WebServlet(name = "ServletUpdateCar")
public class ServletUpdateCar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String manifacrurer=request.getParameter("manifacrurer");

        String color = request.getParameter("color");
        String sell = request.getParameter("sell");
        Double price=Double.parseDouble(request.getParameter("price"));

        int data=Integer.parseInt(request.getParameter("data"));

        Double driven = Double.parseDouble(request.getParameter("driven"));



        CarDao carDao=new CarDao();

        Car car=new Car(id,name,manifacrurer,color,price,data,driven,sell);

        String errMess="";

        if(!(sell.equals("yes")||sell.equals("no"))){
            errMess="selling maust bi yes/no ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("/page/updateCar.jsp").forward(request, response);
        }
        else if(Validation.isValid(name)){
            errMess="name  error  name is emptty ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("/page/updateCar.jsp").forward(request, response);
        }else  if( Validation.isValid(manifacrurer)){
            errMess="Password  error  manifacrurer is emptty ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("/page/updateCar.jsp").forward(request, response);
        }else  if( Validation.isValid(color)){
            errMess="name  error  color is emptty ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("page/updateCar.jsp").forward(request, response);        }
        else  if( price<0){
            errMess="price  can not be <0 ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("page/updateCar.jsp").forward(request, response);        }
        else  if(data<1800 || (data)>2019|| Validation.isValid(request.getParameter("data"))){
            errMess="data must be 1800-2019 ";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("updateCar.jsp").forward(request, response);        }
        else if(  carDao.updateCar(car)!=0){
            errMess="scsessful add Car";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("/page/myCar.jsp").forward(request, response);


        }
        else  {
            errMess="You have mistake";
            request.setAttribute("errMess",errMess);
            request.getRequestDispatcher("/page/addCar.jsp").forward(request, response);
        }
    }

}
