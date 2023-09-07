<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Page</title>
<link href="../css/signup.css" rel="stylesheet">
</head>
<body>
<h1>Customer page</h1>
<form action="" style="width: 400px">
<fieldset>
<legend> Customer Login</legend>
<label for="email">Enter Email:</label>
<input type="email" name="email"  placeholder="enter Email" required="required"><br>
<label>Enter Password:</label>
<input type="password" name="password"  placeholder="enter Password" required="required"><br>
<br>
<button type="submit">Log-In</button>
<button type="reset">Cancel</button>
<br>
<h3>New? <a href="customer/signup"> <br>Click here to SignUp</a></h3>
</fieldset>
</form>
<br>
<a href="/"><button>Back</button></a>
</body>
</html>