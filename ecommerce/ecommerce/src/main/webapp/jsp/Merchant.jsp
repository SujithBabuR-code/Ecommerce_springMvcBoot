<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/signup.css" rel="stylesheet">
<title>Merchant Page</title>
</head>
<body>
<h1>Merchant page</h1>
<form action="" style="width: 400px;">
<fieldset>
<legend> Merchant Login</legend>
<input type="email" name="email"  placeholder="enter Email" required="required"><br>
<input type="password" name="password"  placeholder="enter Password" required="required"><br>
<br>
<button type="submit">Log-In</button>
<button type="reset">Cancel</button>
<h3>New? <a href="merchant/signup"> <br>Click here to SignUp</a></h3>
</fieldset>
</form>
<br>
<a href="/"><button>Back</button></a>
</body>
</html>