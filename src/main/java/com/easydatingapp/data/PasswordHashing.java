package com.easydatingapp.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public class PasswordHashing 
{
	public static String _saltSecret = "YO BROSKI!!";
	
	private static String generatePasswordHash(String passwordToHash, byte[] salt) {
        
	    String passwordHash = null;
	    try 
	    {
	        MessageDigest md = MessageDigest.getInstance("SHA-512");
	        md.update(salt);
	        byte[] bytes = md.digest(passwordToHash.getBytes());
	        
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < bytes.length; i++)
	        {
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        
	        passwordHash = sb.toString();
	    } 
	    catch (NoSuchAlgorithmException e) 
	    {
	        e.printStackTrace();
	    }
	    return passwordHash;
	}
	
	public static byte[] generateSalt(String input) 
	{
	    byte[] salt = new byte[16];
		try
		{
		    SecureRandom sr = SecureRandom.getInstance(input);
		    sr.nextBytes(salt);
		}
		catch (NoSuchAlgorithmException e) {e.printStackTrace();}
	    return salt;

	}
	
	public static int checkPassword(String password, String userId)
	{
		// generate hashed password from passed in password
		byte[] salt = generateSalt(_saltSecret);
		String passwordHash = generatePasswordHash(password, salt);
		
		// fetch user's password hash in database
		Query passwordQuery = Persistence._entityManager.createQuery("SELECT password FROM Users u WHERE u.userid = :userId");
		passwordQuery.setParameter("userId", userId);
		passwordQuery.setParameter("passwordHash", passwordHash);
		passwordQuery.setMaxResults(1);
		
		// compare password
		Object dbPassword = passwordQuery.getSingleResult();
		
		if (dbPassword == passwordHash)
		{
			return 1;
		}
		
		return 0;
	}
}
