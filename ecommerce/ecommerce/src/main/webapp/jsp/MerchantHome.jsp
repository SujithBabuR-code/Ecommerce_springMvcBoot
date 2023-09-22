<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Merchant home page</title>
<link href="../css/homepage.css" rel="stylesheet">
</head>
<body>
<h1>Merchant Home Page</h1>
<h1 style="color: green">${pos}</h1>
<h1 style="color: red">${neg}</h1>
<div>
	<a href="/merchant/productpage"><button>Add Item</button></a>
	<a href="/merchant/viewItems"><button>View Items</button></a>
	<a href="/logout"><button>Log Out </button></a>
</div>
</body>
</html>