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
    String driver="";
    String url = "";
    String username="";
    String password="";
    Connection conn=null;
    public DataSource()
    {
        this.driver="oracle.jdbc.driver.OracleDriver";
        this.url="jdbc:oracle:thin:@localhost:1521:xe";
        this.username="dashboard";
        this.password="itachi";
    }
    public Connection getConnection()
    {
        try
        {
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
