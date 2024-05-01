/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minidesktop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author harsh
 */
public class Verify {
    
    public static Connection get_connection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=null;
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lpu","root","");
            return conn;
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public static boolean check(String user_name,String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=get_connection();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from user_info");
            while(rs.next()){
            //System.out.println(rs.getInt(1)+"  "+rs.getString(2));
             if(user_name.compareTo(rs.getString(1))==0 && password.compareTo(rs.getString(2))==0){
                System.out.print("Verified successfully.");
                   return true;
              }
            }
        }catch(ClassNotFoundException | SQLException e){
           System.out.println(e);
        }
        return false;
    }
}

