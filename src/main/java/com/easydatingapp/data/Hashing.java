package com.easydatingapp.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Hashing
{
	public static String generateHashWithSalt(String input, byte[] salt) 
	{
	    String hash = null;
	    try
	    {
	        MessageDigest md = MessageDigest.getInstance("SHA-512");
	        md.update(salt);
	        byte[] bytes = md.digest(input.getBytes());
	        
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < bytes.length; i++)
	        {
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        
	        hash = sb.toString();
	    } 
	    catch (NoSuchAlgorithmException e) 
	    {
	        e.printStackTrace();
	    }
	    return hash;
	}
	
	public static String generateHash(String input) 
	{
	    String hash = null;
	    try
	    {
	        MessageDigest md = MessageDigest.getInstance("SHA-512");
	        byte[] bytes = md.digest(input.getBytes());
	        
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < bytes.length; i++)
	        {
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        
	        hash = sb.toString();
	    } 
	    catch (NoSuchAlgorithmException e) 
	    {
	        e.printStackTrace();
	    }
	    return hash;
	}
	
	
	public static byte[] generateSalt() 
	{
	    byte[] salt = new byte[16];

	    SecureRandom sr = new SecureRandom();
	    sr.nextBytes(salt);
	    
	    return salt;
	}
}
