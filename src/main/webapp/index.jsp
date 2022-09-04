<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Form</title>
</head>
<body>
 <form action="api/registerUser" method="POST">
  <label for="email">Email:</label><br>
  <input value="hello@gmail.com" type="text" id="email" name="email"><br>
  
  <label for="password">Password:</label><br>
  <input value="hello123" type="text" id="password" name="password">
  
  <label for="firstName">First Name:</label><br>
  <input value="bodhi" type="text" id="firstName" name="firstName"><br>
  
  <label for="lastName">Last name:</label><br>
  <input value="judd" type="text" id="lastName" name="lastName">
  
  <input type="submit">
</form>
</body>
</html>