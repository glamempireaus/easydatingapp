package com.easydatingapp.rest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import com.easydatingapp.data.Database;
import com.easydatingapp.data.PasswordHashing;
import com.easydatingapp.data.entities.User;
import com.easydatingapp.rest.messages.RegisterUserMessage;
import com.easydatingapp.utils.Sanitize;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class Actions
{
    public static RegisterUserMessage registerUser(String email, String password, String firstName, String lastName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        RegisterUserMessage registerUserMessage = new RegisterUserMessage();
        
        // check empty inputs
        
        if (email == null || email.isEmpty())
        {
        	registerUserMessage.errorCode = 1;
        	return registerUserMessage;
        }
        
        if (password == null || password.isEmpty())
        {
        	registerUserMessage.errorCode = 2;
        	return registerUserMessage;
        }
        
        if (firstName == null || firstName.isEmpty())
        {
        	registerUserMessage.errorCode = 3;
        	return registerUserMessage;
        }
        
        if (lastName == null || lastName.isEmpty())
        {
        	registerUserMessage.errorCode = 4;
        	return registerUserMessage;
        }
        
        // sanitize input
        
        String processedEmail = Sanitize.email(email);
        String processedFirstName = Sanitize.personName(firstName);
        String processedLastName = Sanitize.personName(lastName);
        
        // get password hash
        
        byte[] salt = PasswordHashing.generateSalt();
		String processedPassword = PasswordHashing.generateHash(password, salt);
		
        // check for a duplicate email address

		try
		{
			String query = "SELECT id FROM users WHERE email = ?";

			PreparedStatement statement = Database.connection.prepareStatement(query);
			statement.setString(1, processedEmail);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next())
			{
				registerUserMessage.errorCode = 5;
	        	return registerUserMessage;
			}
			
		}
		catch (SQLException e)
		{
	    	e.printStackTrace();
	    	
			registerUserMessage.errorCode = 100;
        	return registerUserMessage;
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
				registerUserMessage.errorCode = 100;
	        	return registerUserMessage;
			}
			
		}
		catch (SQLException e)
		{
	    	e.printStackTrace();
	    	
	    	registerUserMessage.errorCode = 10;
        	return registerUserMessage;
		}
        
        
        // authenticate user
        registerUserMessage.authenticated = true;
        return registerUserMessage;
    }
    
	/*
	 * public static LoginUserMessage loginUser(String email, String password,
	 * HttpServletRequest httpServletRequest, HttpServletResponse
	 * httpServletResponse) { LoginUserMessage loginUserMessage = new
	 * LoginUserMessage();
	 * 
	 * ResultSet resultSet;
	 * 
	 * try { String query = "" Statement statement =
	 * Database.connection.createStatement(); resultSet =
	 * statement.executeQuery(query);
	 * 
	 * if (!resultSet.next()) { requestLoginMessage.errorCode = 4; return
	 * requestUserMessage; }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * }
	 */
}