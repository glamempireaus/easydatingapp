package com.easydatingapp;

import com.easydatingapp.data.Database;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;


@Singleton
@Startup
public class Main 
{
	@PostConstruct
    public void main()
    {
        init();
		
    	System.out.println("Server Initialised.");
        
    	Database.init();
        
        System.out.println("Database Initialised.");
    }

    public static void init()
    {
    	
    }
}
