package com.easydatingapp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestUser
{
    public static RequestUserMessage requestUser(String user, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        RequestUserMessage requestUserMessage = new RequestUserMessage();
        return requestUserMessage;
    }
}