package com.easydatingapp.rest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.easydatingapp.data.Database;
import com.easydatingapp.data.PasswordHashing;
import com.easydatingapp.rest.messages.RegisterUserRequest;
import com.easydatingapp.rest.messages.RegisterUserResponse;
import com.easydatingapp.utils.Sanitize;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RestActions
{
    public static RegisterUserResponse registerUser(RegisterUserRequest request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
    	RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        
        // check empty inputs
        
        if (request.email == null || request.email.isEmpty())
        {
        	registerUserResponse.errorCode = 1;
        	return registerUserResponse;
        }
        
        if (request.password == null || request.password.isEmpty())
        {
        	registerUserResponse.errorCode = 2;
        	return registerUserResponse;
        }
        
        if (request.firstName == null || request.firstName.isEmpty())
        {
        	registerUserResponse.errorCode = 3;
        	return registerUserResponse;
        }
        
        if (request.lastName == null || request.lastName.isEmpty())
        {
        	registerUserResponse.errorCode = 4;
        	return registerUserResponse;
        }
        
        // sanitize input
        
        String processedEmail = Sanitize.email(request.email);
        String processedFirstName = Sanitize.personName(request.firstName);
        String processedLastName = Sanitize.personName(request.lastName);
        
        // get password hash
        
        byte[] salt = PasswordHashing.generateSalt();
		String processedPassword = PasswordHashing.generateHash(request.password, salt);
		
        // check for a duplicate email address

		try
		{
			String query = "SELECT id FROM users WHERE email = ?";

			PreparedStatement statement = Database.connection.prepareStatement(query);
			statement.setString(1, processedEmail);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next())
			{
				registerUserResponse.errorCode = 5;
	        	return registerUserResponse;
			}
			
		}
		catch (SQLException e)
		{
	    	e.printStackTrace();
	    	
	    	registerUserResponse.errorCode = 100;
        	return registerUserResponse;
		}
        
        // place into database
        
		try
		{
			String query = "INSERT INTO users (email, passwordhash, firstname, lastname, passwordsalt, creationtimestamp) VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = Database.connection.prepareStatement(query);
			statement.setString(1, processedEmail);
			statement.setString(2, processedPassword);
			statement.setString(3, processedFirstName);
			statement.setString(4, processedLastName);
			statement.setString(5, salt.toString());
			statement.setDate(6, new java.sql.Date(new java.util.Date(System.currentTimeMillis()).getTime()));
			
			int queryResult = statement.executeUpdate();
			if (queryResult != 1)
			{
				registerUserResponse.errorCode = 100;
	        	return registerUserResponse;
			}
			
		}
		catch (SQLException e)
		{
	    	e.printStackTrace();
	    	
	    	registerUserResponse.errorCode = 10;
        	return registerUserResponse;
		}
        
        
        // authenticate user
		registerUserResponse.authenticated = true;
        return registerUserResponse;
    }
}