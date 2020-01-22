/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itachi.dashboard.startup;


/**
 *
 * @author mohan
 */

import java.sql.*;

public class DataSource {

    public static  Connection getConnection()
    {
        String driver="";
        String url = "";
        String username="";
        String password="";
        Connection conn=null;
        
        try
        {
        	//driver="oracle.jdbc.driver.OracleDriver";
        	driver="com.mysql.cj.jdbc.Driver";
            //url="jdbc:oracle:thin:@localhost:1521:xe";
            url="jdbc:mysql://localhost:3306/sonoo";
            username="dashboard";
            password="itachi";
            
            
        	Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            if (conn != null)
            {
                System.out.println("connection established...");
            }
            else
            {
                System.out.println("connection failed...");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
