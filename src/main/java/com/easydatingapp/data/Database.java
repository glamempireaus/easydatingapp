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
	public static String connectionUrl = "jdbc:postgresql://localhost/easydating";
	public static Connection connection;
	
	public static void init()
	{
	    try
	    {
			Class.forName("org.postgresql.Driver");
	    	connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/easydating?currentSchema=public&user=postgres&password=1212");
	    }
	    catch (SQLException | ClassNotFoundException e)
	    {
	    	e.printStackTrace();
	    	
	    }   
	}
}