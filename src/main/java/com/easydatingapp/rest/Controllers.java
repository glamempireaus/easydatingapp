package com.easydatingapp.rest;


import com.easydatingapp.actions.RequestUser;
import com.easydatingapp.actions.RequestUserMessage;

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
public class Controllers 
{
    @Context ServletContext context;
    @Context HttpServletRequest httpServletRequest;
    @Context HttpServletResponse httpServletResponse;

    @POST
    @Path("/requestUser")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public RequestUserMessage requestUser(@FormParam("user") String user)
    {
      return RequestUser.requestUser(user, httpServletRequest, httpServletResponse);
    }
}