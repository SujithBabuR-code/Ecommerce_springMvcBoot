<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="x" uri="http://www.springframework.org/tags/form"%>
<link href="../css/signup.css" rel="stylesheet">
<title>Merchant Signup Page</title>
</head>
<body>
	<h1>Merchant Signup</h1>
	<h1 style="color: red">${neg}</h1>
	<x:form action="/merchant/signup" method="post"
		modelAttribute="merchantDto">
		<fieldset>
			<legend>Merchant SignUp,</legend>
			<table>
				<tr>
					<th>Name:</th>
					<th><x:input path="name" /></th>
					<th><x:errors class="errors" path="name" /></th>
				</tr>
				<tr>
					<th>Mobile:</th>
					<th><x:input type="tel" path="mobile" pattern="[0-9]{10}" /></th>
					<th><x:errors class="errors" path="mobile" /></th>
				</tr>
				<tr>
					<th>Email:</th>
					<th><x:input type="email" path="email" /></th>
					<th><x:errors  class="errors" path="email" /></th>
				</tr>
				<tr>
					<th>Password:</th>
					<th><x:password path="password" /></th>
					<th><x:errors class="errors" path="password" /></th>
				</tr>
				<tr>
					<th>Date of Birth:</th>
					<th><x:input type="date" path="dob" /></th>
					<th><x:errors class="errors" path="dob" /></th>
				</tr>
				<tr>
					<th>Gender:</th>
					<th><x:radiobutton path="gender" value="male"
							 />Male <x:radiobutton path="gender"
							value="female" />Female</th>
					<th><x:errors class="errors" path="gender" /></th>
				</tr>
				<tr>
					<th><button>Sign up</button></th>
					<th><button type="reset">Cancel</button></th>
					<th></th>
				</tr>
			</table>
		</fieldset>

	</x:form>
	<br>
	<a href="/merchant"><button>Back</button></a>

</body>
</html>