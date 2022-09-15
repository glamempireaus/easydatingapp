package com.easydatingapp.utils;

public class Logger
{
	public static void toConsole(String message)
	{
		message = message.substring(0, 1).toUpperCase() + message.substring(1);
		System.out.println(message);
	}
}
