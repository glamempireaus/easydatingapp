package com.easydatingapp.utils;

public class Sanitize
{
  public static String numeric(String in)
  {
    return in.replaceAll("[^\\p{Digit}]", "").trim();
  }
  
  public static String alpha(String in)
  {
	  return in.replaceAll("[^\\p{Alpha}]", "").trim();
  } 
  
  public static String alphaSpace(String in)
  {
	  return in.replaceAll("[^\\p{Alpha} ]", "").trim();
  }  
  
  public static String alphaNumeric(String in)
  {
	  return in.replaceAll("[^\\p{Alpha}\\p{Digit}]", "").trim();
  }
  
  public static String alphaHyphen(String in)
  {
	  return in.replaceAll("[^\\p{Alpha}\\-]", "").trim();
  }
  
  public static String alphaUnderscore(String in)
  {
	  return in.replaceAll("[^\\p{Alpha}_]", "").trim();
  }
  
  public static String alphaNumericUnderscoreHyphen(String in)
  {
	  return in.replaceAll("[^\\p{Alpha}\\p{Digit}_\\-]", "").trim();
  }  
  
  public static String alphaNumericAndSymbols(String in)
  {
	  return in.replaceAll("[^\\p{Alpha}\\p{Digit} \\Q-~`!@#$%^&*()=_+[]{}\\|;:'\",.<>/?\\E]", "").trim();
  }
  
  public static String login(String in)
  {
	  return in.replaceAll("[^\\p{Alpha}\\p{Digit}\\-]", "").trim();
  }  

  public static String alias(String in)
  {
	  return in.replaceAll("[^\\p{Alpha}\\p{Digit}\\Q_.\\E]", "").trim(); // no hyphen so can't clash with login
  }  
  
  public static String email(String in)
  {
	  return in.replaceAll("[^\\p{Alpha}\\p{Digit}@.\\-+_]", "").trim();
  }

  public static String personName(String in)
  {
	  return in.replaceAll("[^\\p{Alpha} &/.()\\-,']", "").trim();
  } 
  
  public static String phone(String in)
  {
	  return in.replaceAll("[^\\p{Digit}]", "").trim();
  }
  
  public static String streetName(String in)
  {
	  return in.replaceAll("[^\\p{Alpha}\\p{Digit} \\-&/#.,;:'°]", "").trim();
  }

  public static String suburb(String in)
  {
	  return in.replaceAll("[^\\p{Alpha} \\-,.;'&/.()]", "").trim();
  }
  
  public static String postcode(String in)
  {
	  return in.replaceAll("[^\\p{Digit}]", "").trim();
  }
  
  public static String state(String in)
  {
	  return in.replaceAll("[^\\p{Alpha} ]", "").trim();
  } 
  
  public static String businessName(String in)
  {
	  return in.replaceAll("[^\\p{Alpha}\\p{Digit} &/()\\-#.,;:']", "").trim();
  }    
  
  public static String businessLevel(String in)
  {
	  return in.replaceAll("[^\\p{Alpha}\\p{Digit} &/()\\-#.,;:']", "").trim();
  }  
  
  
  public static String ccValidation(String in)
  {
	  return in.replaceAll("[^\\p{Alpha}\\p{Digit}:@.\\-+_ ]", "").trim();
  }
   
}
