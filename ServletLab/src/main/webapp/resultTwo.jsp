<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Concatenation Result</title>
</head>
<body>
	<p>${uRes.getNumberOne()} and ${uRes.getNumberTwo()} combined as a string is ${uRes.getConcatenate()}.</p>
	<a href="index.jsp">Enter more numbers to manipulate.</a>

</body>
</html>