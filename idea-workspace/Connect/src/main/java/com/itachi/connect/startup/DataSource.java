/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itachi.connect.startup;


/**
 *
 * @author mohan
 */

import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DataSource {
    String driver="";
    String url = "";
    String username="";
    String password="";
    Connection conn=null;
    Logger logger = null;
    public DataSource()
    {
        this.driver="oracle.jdbc.driver.OracleDriver";
        this.url="jdbc:oracle:thin:@localhost:1521:xe";
        this.username="dashboard";
        this.password="itachi";
        System.out.println("datasorce initilized...");
    }
    public Connection getConnection()
    {
        try
        {
            logger = new LogHandler().getLoggerBean(this.getClass());
        	Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("trace enabled? "+logger.isTraceEnabled());
            System.out.println("debug enabled? "+logger.isDebugEnabled());
            System.out.println("error enabled? "+logger.isErrorEnabled());
            if (conn != null)
            {
                logger.trace("tarce: connection established...");
                logger.debug("debug: connection established...");
                logger.warn("connection established...");
                logger.error("connection established...");
                logger.fatal("connection established...");


            }
            else
            {
                logger.trace("trace: connection failed...");
                logger.debug("debug: connection failed...");
                logger.warn("warn: connection failed...");
                logger.error("error: connection failed...");
                logger.fatal("fatal: connection failed...");



            }
        }
        catch(Exception e)
        {
            logger.debug("debug: Unable to create database connection.",e);
            logger.warn("warn: Unable to create database connection.",e);
            logger.error("error: Unable to create database connection.",e);


        }
        return conn;
    }
}
