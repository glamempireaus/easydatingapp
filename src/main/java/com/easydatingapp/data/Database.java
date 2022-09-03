package com.easydatingapp.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import jakarta.annotation.PostConstruct;

import jakarta.ejb.Startup;


public class Database
{
	public static String username = "bodhi";
	public static String password = "test123";
	public static String connectionUrl = "jdbc:postgres://localhost:easydating";
	public static Connection connection;
	
	public static void init()
	{
		
		
	    Properties connectionProperties = new Properties();
	    connectionProperties.put("postgres", username);
	    connectionProperties.put("1212", password);

	    try
	    {
	    	connection = DriverManager.getConnection(connectionUrl, connectionProperties);
	    }
	    catch (SQLException e)
	    {
	    	e.printStackTrace();
	    	
	    }   
	}
}