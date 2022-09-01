package com.easydatingapp.rest;


import com.easydatingapp.actions.RegisterUser;
import com.easydatingapp.actions.RegisterUserMessage;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
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
    @Path("/requestUser")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public RegisterUserMessage registerUser(@FormParam("email") String email, @FormParam("password") String password, @FormParam("firstName") String firstName, @FormParam("lastName")  String lastName)
    {
      return RegisterUser.registerUser(email, password, firstName, lastName, httpServletRequest, httpServletResponse);
    }
}
