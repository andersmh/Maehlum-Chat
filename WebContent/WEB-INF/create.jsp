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

	<div align="center">

		<h1>Create account</h1><br><br>
		<form action="CreateServlet" method="post">

			<input type="text" name="firstName" id="firstNameID"
				placeholder="First name" onInput="firstNameValidation()">
			<p style="display: inline" id="firstNameMessage"></p>
			<br><br> <input type="text" name="lastName" id="lastNameID"
				placeholder="Last name" onInput="lastNameValidation()">
			<p style="display: inline" id="lastNameMessage"></p>
			<br><br> <input type="email" name="email" id="emailID"
				placeholder="something@something.something"
				onInput="emailValidation()">
			<p style="display: inline" id="emailMessage"></p>
			<br><br> <input type="text" name="username" id="usernameID"
				placeholder="Username" onInput="usernameNameValidation()">
			<p style="display: inline" id="usernameMessage"></p>
			<br><br> <input type="password" name="password1" id="password1ID"
				placeholder="Password" onInput="password1Validation()">
			<p style="display: inline" id="password1Message"></p>
			<br><br> <input type="password" name="password2" id="password2ID"
				placeholder="Repeat password" onInput="password2Validation()">
			<p style="display: inline" id="password2Message"></p>
			<br><br> <input type="submit" value="Create"> <br> <br>

		</form>

		<a href="LoginServlet">Back to login</a>

	</div>

	<script src="js/validation.js"></script>
</body>
</html>