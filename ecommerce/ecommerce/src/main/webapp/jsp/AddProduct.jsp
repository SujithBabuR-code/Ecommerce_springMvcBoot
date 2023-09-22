<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product Page</title>
<link href="../css/signup.css" rel="stylesheet">
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
</head>
<body>
	<h1>Add product page</h1>
	<mvc:form action="/merchant/add-product" method="post"
		modelAttribute="productDto" enctype="multipart/form-data">
		<table>
			<tr>
				<th>Name:</th>
				<th><mvc:input path="name" /></th>
				<th><mvc:errors class="errors-mvc" path="name" /></th>
			</tr>
			<tr>
				<th>Stock:</th>
				<th><mvc:input path="stock" /></th>
				<th><mvc:errors class="errors-mvc" path="stock" /></th>
			</tr>
			<tr>
				<th>Price:</th>
				<th><mvc:input path="price" /></th>
				<th><mvc:errors  class="errors-mvc" path="price" /></th>
			</tr>
			<tr>
				<th>Category:</th>
				<th><mvc:select path="category">
						<mvc:option value="">Select One Option</mvc:option>
						<mvc:option value="Clothing">Clothing</mvc:option>
						<mvc:option value="Electronics">Electronics</mvc:option>
						<mvc:option value="Provisions">Provisions</mvc:option>
					</mvc:select></th>
				<th><mvc:errors class="errors-mvc" path="category" /></th>
			</tr>
			<tr>
				<th>Picture:</th>
				<th><input type="file" name="pic"></th>
				<th></th>
			</tr>
			<tr>
				<th><button>Add</button></th>
				<th><button>Cancel</button></th>
			</tr>
		</table>
	</mvc:form>
</body>
</html>