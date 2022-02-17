<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit To-Do Item</title>
</head>
<body>
	<form action = "EditToDoServlet" method="post">
	Description: <input type ="text" name = "description" value= "${toDoToEdit.description}">
	Priority: <input type = "text" name = "priority" value= "${toDoToEdit.priority}">
	Complete: <input type = "text" name = "complete" value= "${toDoToEdit.complete}">
	<input type = "hidden" name = "id" value="${toDoToEdit.id}">
	<input type = "submit" value="Save Edited Item">
</form>

</body>
</html>