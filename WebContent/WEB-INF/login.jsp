<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mæhlum Chat</title>
<link rel="stylesheet" href="css/look.css">
<link href="https://fonts.googleapis.com/css?family=Work+Sans:200"
	rel="stylesheet">
</head>
<body>
<br><br><br><br><br><br><br><br><br><br>
	<div align="center">
		<h1>Mæhlum Chat</h1>
		<form action="LoginServlet" method="POST">
			<input type="text" name="username" placeholder="username"><br><br>
			<input type="password" name="password" placeholder="password"><br><br>
			<input type="submit" value="Login"><br> <br>
		</form>
		<a href="CreateServlet">Create account</a>
		<p style="color: red;">${errorMessage}</p>

	</div>




</body>
</html>