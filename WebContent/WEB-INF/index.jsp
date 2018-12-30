<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/look.css">
<link href="https://fonts.googleapis.com/css?family=Work+Sans:200"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Mæhlum Chat</title>
</head>
<body>

	<div align="center">

		<h1>Mæhlum Chat</h1>


		<div id="message">

			<c:forEach items="${viewMessages}" var="viewMessages">
	
    	${viewMessages.date} ${viewMessages.sender}  : ${viewMessages.message}<br>

			</c:forEach>

		</div>
		<br> <br> <br>


		<form action="IndexServlet" method="post">
			<input type="text" name="message" placeholder="Write something...">&nbsp;<input
				type="submit" value="send"><br>
		</form>
		<br> <br> <a href="LogoutServlet">Logout</a>
	</div>


</body>
</html>