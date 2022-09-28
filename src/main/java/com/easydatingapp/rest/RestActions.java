package com.easydatingapp.rest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.easydatingapp.data.Database;
import com.easydatingapp.data.Hashing;
import com.easydatingapp.rest.messages.LoginUserRequest;
import com.easydatingapp.rest.messages.LoginUserResponse;
import com.easydatingapp.rest.messages.RegisterUserRequest;
import com.easydatingapp.rest.messages.RegisterUserResponse;
import com.easydatingapp.rest.messages.FetchUserMatchesRequest;
import com.easydatingapp.rest.messages.FetchUserMatchesResponse;
import com.easydatingapp.utils.Sanitize;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RestActions
{
	public static RegisterUserResponse registerUser(RegisterUserRequest request, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
	{
		RegisterUserResponse response = new RegisterUserResponse();

		// check empty inputs

		if (request.email == null || request.email.isEmpty())
		{
			response.errorCode = 1;
			return response;
		}

		if (request.password == null || request.password.isEmpty())
		{
			response.errorCode = 2;
			return response;
		}

		if (request.firstName == null || request.firstName.isEmpty())
		{
			response.errorCode = 3;
			return response;
		}

		if (request.lastName == null || request.lastName.isEmpty())
		{
			response.errorCode = 4;
			return response;
		}

		// sanitize input

		String processedEmail = Sanitize.email(request.email);
		String processedFirstName = Sanitize.personName(request.firstName);
		String processedLastName = Sanitize.personName(request.lastName);

		// get password hash

		byte[] salt = Hashing.generateSalt();
		String passwordHash = Hashing.generateHashUsingSalt(request.password, salt);

		// check for a duplicate email address

		try
		{
			String query = "SELECT id FROM users WHERE email = ?";

			PreparedStatement statement = Database.connection.prepareStatement(query);
			statement.setString(1, processedEmail);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next())
			{
				response.errorCode = 5;
				return response;
			}

		} catch (SQLException e)
		{
			e.printStackTrace();

			response.errorCode = 100;
			return response;
		}

		// place processed input + hash into database

		try
		{
			String query = "INSERT INTO users (email, passwordhash, firstname, lastname, passwordsalt, creationtimestamp) VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = Database.connection.prepareStatement(query);
			statement.setString(1, processedEmail);
			statement.setString(2, passwordHash);
			statement.setString(3, processedFirstName);
			statement.setString(4, processedLastName);
			statement.setBytes(5, salt);
			statement.setDate(6, new java.sql.Date(new java.util.Date(System.currentTimeMillis()).getTime()));

			int queryResult = statement.executeUpdate();
			if (queryResult != 1)
			{
				response.errorCode = 100;
				return response;
			}

		} catch (SQLException e)
		{
			e.printStackTrace();

			response.errorCode = 100;
			return response;
		}

		// authenticate user
		response.authenticated = true;
		return response;
	}

	public static LoginUserResponse loginUser(LoginUserRequest request, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
	{
		LoginUserResponse response = new LoginUserResponse();

		// check empty inputs

		if (request.email == null || request.email.isEmpty())
		{
			response.errorCode = 1;
			return response;
		}

		if (request.password == null || request.password.isEmpty())
		{
			response.errorCode = 2;
			return response;
		}

		String processedEmail = Sanitize.email(request.email); // sanitize input

		// get user's password salt

		byte[] userSalt;
		int userId;
		try
		{
			String query = "SELECT id, passwordsalt FROM users WHERE email = ?";

			PreparedStatement statement = Database.connection.prepareStatement(query);
			statement.setString(1, processedEmail);

			ResultSet resultSet = statement.executeQuery();

			// check if incorrect email

			if (!resultSet.next())
			{
				response.errorCode = 3;
				return response;
			}

			userId = resultSet.getInt(1);
			userSalt = resultSet.getBytes(2);
		} catch (SQLException e)
		{
			e.printStackTrace();

			response.errorCode = 100;
			return response;
		}

		// create password hash

		String passwordHash = Hashing.generateHashUsingSalt(request.password, userSalt);

		// attempt login with hashed password

		try
		{
			String query = "SELECT id FROM users WHERE email = ? AND passwordhash = ?";

			PreparedStatement statement = Database.connection.prepareStatement(query);
			statement.setString(1, processedEmail);
			statement.setString(2, passwordHash);

			ResultSet resultSet = statement.executeQuery();

			// handle incorrect password

			if (!resultSet.next())
			{
				response.errorCode = 2;
				return response;
			}

		} catch (SQLException e)
		{
			e.printStackTrace();

			response.errorCode = 100;
			return response;
		}

		// create a new session hash

		String sessionHash = Hashing.generateHashUsingSalt(request.email, Hashing.generateSalt());

		// store session hash

		try
		{
			String query = "INSERT INTO usersessions (id, sessionhash) VALUES (?, ?)";

			PreparedStatement statement = Database.connection.prepareStatement(query);
			statement.setInt(1, userId);
			statement.setString(2, sessionHash);

			int queryResult = statement.executeUpdate();
			if (queryResult != 1)
			{
				response.errorCode = 100;
				return response;
			}

		} catch (SQLException e)
		{
			e.printStackTrace();

			response.errorCode = 100;
			return response;
		}

		// build response object

		response.sessionToken = sessionHash;
		response.authenticated = true;

		return response;
	}

	public static FetchUserMatchesResponse fetchUserMatches(FetchUserMatchesRequest request, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
	{
		FetchUserMatchesResponse response = new FetchUserMatchesResponse();
		return response;
	}
}