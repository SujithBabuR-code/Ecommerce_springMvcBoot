<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/verifyotp.css" rel="stylesheet">
<title>Admin verify Otp</title>
</head>
<body>
<h1 id="display">${neg}</h1>
<h1 id="normal">Enter Otp</h1>
	<form action="/admin/verifyotp" method="post">
		<input type="text" name="id" value="${id}" hidden="hidden"> <input
			type="text" name="enteredOtp"><br><br>
		<button>Verify</button>
		<button type="reset">Cancel</button>
	</form>

</body>
</body>
</html>