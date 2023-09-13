<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/signup.css" rel="stylesheet">
<title>Admin page</title>
</head>
<body>
<h1>Admin page</h1>
<h1 id="display">${neg}</h1>
<h1 style="color: green">${pos}</h1>
<form action="/admin/login" method="post">
<fieldset>
<legend>Login</legend>
<input type="email" name="email"  placeholder="enter Email"><br>
<input type="password" name="password"  placeholder="enter Password"><br>
<button type="submit">Log-In</button>
<button type="reset">Cancel</button>
</fieldset>
</form>
<br>
<a href="/"><button>Back</button></a>
</body>
</html>