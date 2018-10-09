package com.carbroker.dao;

import com.carbroker.connection.DBconnection;
import com.carbroker.model.Car;
import com.carbroker.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarDao {


    public static ArrayList<Car> getCarbyEmail(int user_id) {
        ArrayList<Car> cars = new ArrayList<Car>();
        try {
            Connection connection = DBconnection.getInstance();
            PreparedStatement ps = connection.prepareStatement("select * from Car  where user_id = ? ");
            ps.setInt(1, user_id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt(1));
                car.setName(rs.getString(2));
                car.setManifacturer(rs.getString(3));
                car.setColor(rs.getString(4));
                car.setPrice(rs.getDouble(5));
                car.setData(rs.getInt(6));
                car.setDriven(rs.getDouble(7));
                car.setSelling(rs.getString(8));
                car.setUser_id(rs.getInt(9));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public static ArrayList<Car> getAllCar() {
        ArrayList<Car> cars = new ArrayList<Car>();
        try {
            Connection connection = DBconnection.getInstance();
            PreparedStatement ps = connection.prepareStatement("select * from Car where selling='yes' ");


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt(1));
                car.setName(rs.getString(2));
                car.setManifacturer(rs.getString(3));
                car.setColor(rs.getString(4));
                car.setPrice(rs.getDouble(5));
                car.setData(rs.getInt(6));
                car.setDriven(rs.getDouble(7));
                car.setSelling(rs.getString(8));
                car.setUser_id(rs.getInt(9));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public int saveCar(Car car) {
        int flag = 0;
        try {
            Connection connection = DBconnection.getInstance();
            PreparedStatement ps = connection.prepareStatement("insert into car values(0,?,?,?,?,?,?,?,?)");
            ps.setString(1, car.getName());
            ps.setString(2, car.getManifacturer());
            ps.setString(3, car.getColor());
            ps.setDouble(4, car.getPrice());
            ps.setInt(5, car.getData());
            ps.setDouble(6, car.getDriven());
            ps.setString(7, car.getSelling());
            ps.setInt(8, car.getUser_id());
            flag = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public int deletCar(int id) {
        int flag = 0;
        try {
            Connection connection = DBconnection.getInstance();
            PreparedStatement ps = null;
            ps = connection.prepareStatement("delete from  car where  id=?");

            ps.setInt(1, id);
            flag = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Car getCarById(int id) {
        Car car= new Car();

        try {
            Connection connection = DBconnection.getInstance();
            PreparedStatement ps = connection.prepareStatement("select * from Car where id=? ");
            ps.setInt(1, id);

ResultSet rs=ps.executeQuery();

if(rs.next()){

    car.setId(rs.getInt(1));
    car.setName(rs.getString(2));
    car.setManifacturer(rs.getString(3));
    car.setColor(rs.getString(4));
    car.setPrice(rs.getDouble(5));
    car.setData(rs.getInt(6));
    car.setDriven(rs.getDouble(7));
    car.setSelling(rs.getString(8));
    car.setUser_id(rs.getInt(9));


}

        } catch (SQLException e) {
            e.printStackTrace();

        }
return  car;
    }

    public int updateCar(Car car) {
        int flag = 0;
        try {
            Connection connection = DBconnection.getInstance();
            PreparedStatement ps = connection.prepareStatement("update  car set Name=?,Manifacturer=?,color=?,price=?,data=?,driven=?,selling=? where id=?");
            ps.setString(1, car.getName());
            ps.setString(2, car.getManifacturer());
            ps.setString(3, car.getColor());
            ps.setDouble(4, car.getPrice());
            ps.setInt(5, car.getData());
            ps.setDouble(6, car.getDriven());
            ps.setString(7, car.getSelling());
            ps.setInt(8, car.getId());
            flag = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    public int buyCar(User user, Car car) {
        int flag = 0;

        try {
            Connection connection = DBconnection.getInstance();
            connection.setAutoCommit(false);
            PreparedStatement ps = null;
            ps = connection.prepareStatement("update  user set amount=amount-? where  id=?");
            ps.setDouble(1, car.getPrice());
            ps.setInt(2, user.getId());
               ps.executeUpdate();

            ps = connection.prepareStatement("update  user set amount=amount+? where  id=?");
            ps.setDouble(1, car.getPrice());
            ps.setInt(2, car.getUser_id());
            ps.executeUpdate();

            ps = connection.prepareStatement("update  car set selling='no'  where  id=?");
            ps.setInt(1, car.getId());

            ps.executeUpdate();

            ps = connection.prepareStatement("update  car set user_id=? where  id=?");
            ps.setInt(1,user.getId());
            ps.setInt(2, car.getId());
          flag= ps.executeUpdate();
            ///check-----------------------???
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    public static ArrayList<Car> getCarByName(String name) {
        ArrayList<Car> cars = new ArrayList<Car>();
        try {
            Connection connection = DBconnection.getInstance();
            PreparedStatement ps = connection.prepareStatement("select * from Car where Name=? && (selling='yes') ");

  ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt(1));
                car.setName(rs.getString(2));
                car.setManifacturer(rs.getString(3));
                car.setColor(rs.getString(4));
                car.setPrice(rs.getDouble(5));
                car.setData(rs.getInt(6));
                car.setDriven(rs.getDouble(7));
                car.setSelling(rs.getString(8));
                car.setUser_id(rs.getInt(9));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }


}