package com.itachi.dashboard.dao;

import com.itachi.dashboard.startup.*;

import java.sql.Connection;
import java.util.Map;

public class Users {
	Connection conn=null;
        Map outMap =null;
	public Users()
	{
            conn = DataSource.getConnection();
	}
	public Map addUser(Map inputMap)
	{
            return outMap;
	}
}