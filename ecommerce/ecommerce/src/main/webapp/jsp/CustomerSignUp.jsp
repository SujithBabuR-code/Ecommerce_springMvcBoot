<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer SignUp Page</title>
<%@ taglib prefix="x" uri="http://www.springframework.org/tags/form" %>
<link href="../css/signup.css" rel="stylesheet">
</head>
<body>
<x:form action="" style="width: 600px;">
<fieldset>
<legend>Customer Signup Page</legend>
<label>Enter Name:</label>
<input type="text" path="name" required="required"><br>
<label>Enter Email:</label>
<input type="email" path="email" required="required"><br>
<label>Create Password:</label>
<input type="password" name="password" required="required"><br>
<label>Enter Mobile Number:</label>
<input type="tel" name="mobile" required="required"><br>
<label>Enter Date of Birth</label>
<input type="date" name="dob" required="required"><br>
<label for="Gender">Select Gender:</label>
<input type="radio" name="gender">Male
<x:input type="radio" path="gender"/>Female<br>
<button>SignUp</button>
<button type="reset">Cancel</button>
</fieldset>
</x:form>
<br>
<a href="/customer"><button>Back</button></a>
</body>
</html>