package com.easydatingapp.rest;


import com.easydatingapp.rest.messages.RegisterUserRequest;
import com.easydatingapp.rest.messages.RegisterUserResponse;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class RestControllers 
{
    @Context ServletContext context;
    @Context HttpServletRequest httpServletRequest;
    @Context HttpServletResponse httpServletResponse;

    @POST
    @Path("/registerUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RegisterUserResponse registerUser(RegisterUserRequest request)
    {
    	return RestActions.registerUser(request, httpServletRequest, httpServletResponse);
    }	
}