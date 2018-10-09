package com.carbroker.dao;

import com.carbroker.connection.DBconnection;
import com.carbroker.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

    public  static  int save(User user){
        int flag=0;
        try {
            Connection connection= DBconnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user VALUES (0,?,?,?,?,?,?,'0','0','person')");
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setInt(5, user.getAge());
            preparedStatement.setString(6, user.getValidationcod());
            flag =   preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public  User checkValid(String email ,String validator){
        int flag=0;
        User user=null;
        try {
            Connection connection=DBconnection.getInstance();
            connection.setAutoCommit(false);
            PreparedStatement ps=null;
            ps=connection.prepareStatement("select * from user where  email=? && validationcod=?");
            ps.setString(1,email);
            ps.setString(2,validator);

            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstname(rs.getString(4));
                user.setLastname(rs.getString(5));
                user.setAge(rs.getInt(6));
                user.setValidationcod(rs.getString(7));
                user.setAmount(rs.getDouble(9));
                user.setRole(rs.getString(10));
            }

            ps=connection.prepareStatement("update user set  validationcod='null',status=1 where  email=? ");
            ps.setString(1,email);
            ps.executeUpdate();


            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public  User checklogin(String email ,String password){
        int flag=0;
        User user=null;
        try {
            Connection connection=DBconnection.getInstance();
            PreparedStatement ps=connection.prepareStatement("select * from user where  email=? && password=?");
            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setLastname(rs.getString(5));
                user.setFirstname(rs.getString(4));
                user.setAge(rs.getInt(6));
                user.setValidationcod(rs.getString(7));
                user.setStatus(rs.getInt(8));
                user.setAmount(rs.getDouble(9));
                user.setRole(rs.getString(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public  void addMany(String email ,Double many){

        User user=null;
        try {
            Connection connection=DBconnection.getInstance();
            PreparedStatement ps=connection.prepareStatement("update user set  amount=(amount+?) where  email=? ");
            ps.setDouble(1,many);
            ps.setString(2,email);
    ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<User> getAllUser(){
        ArrayList<User> users=new ArrayList<User>();
        try {
            Connection connection=DBconnection.getInstance();
            PreparedStatement ps=connection.prepareStatement("select * from user ");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstname(rs.getString(4));
                user.setLastname(rs.getString(5));
                user.setAge(rs.getInt(6));
                user.setValidationcod(rs.getString(7));
                user.setStatus(rs.getInt(8));
                user.setAmount(rs.getDouble(9));
                user.setRole(rs.getString(10));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public  int   BlockUserwhitproduct(int id){
         int flag =0;
        try {
            Connection connection=DBconnection.getInstance();
            PreparedStatement ps=connection.prepareStatement("update user set status=2 where  id=? ");
            ps.setDouble(1,id);

           flag= ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
return flag;
    }
}
