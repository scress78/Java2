<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Math Operations</title>
</head>
<body>
	<h1>Number and text operations!</h1>
	<form action="getAdditionServlet" method="post"
>Enter two numbers to perform operations

<input type="text" name="userNumberOne" size="10">  
<input type="text" name="userNumberTwo" size="10">
<input type="submit" value="Perform Operations!">
</form>

<form action="getConcatenationServlet" method="post"
>Enter two numbers to perform concatenation

<input type="text" name="userNumberOneC" size="10">  
<input type="text" name="userNumberTwoC" size="10">
<input type="submit" value="Perform Concatenation!">
</form>

</body>
</html>