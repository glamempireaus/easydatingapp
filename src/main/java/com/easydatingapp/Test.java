package com.easydatingapp;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class Test {

   @GET
   @Path("/hello")
   public String sayHello() {
      return "Hello World";
   }
   
   @GET
   @Path("/gb")
   public String sayGB() {
      return "Goodbye";
   }
}