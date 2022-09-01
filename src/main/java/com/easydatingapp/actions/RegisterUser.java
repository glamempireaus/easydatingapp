package com.easydatingapp.actions;

import com.easydatingapp.data.PersistenceManager;
import com.easydatingapp.data.entities.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterUser
{
    public static RegisterUserMessage registerUser(String email, String password, String firstName, String lastName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        RegisterUserMessage requestUserMessage = new RegisterUserMessage();
        
        //PersistenceManager._entityManager;
        
        // sanitize input
        
        // check input errors
        
        // get password hash
        
        // create new User
        User newUser = new User(email, firstName, lastName,  password);
        
        // place into database
        PersistenceManager._entityManager.persist(newUser);
        
        // authenticate user
        requestUserMessage.authenticated = true;
        
        
        return requestUserMessage;
    }
}