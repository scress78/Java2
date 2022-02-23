<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To Do Items</title>
</head>
<body>
	<form method = "post" action = "NavigationServlet">
	
	<table>
		<tr>
			<td>Task</td>
			<td>Priority</td>
			<td>Done?</td>
		<tr>
		<c:forEach items="${requestScope.allItems}" var="currentitem">
		<tr>
		 <td><input type="radio" name="id" value="${currentitem.id}"></td>
		 <td>${currentitem.description}</td>
		 <td>${currentitem.priority}</td>
		 <td>${currentitem.complete}</td>
		 </tr>
		</c:forEach>
	</table>

	<input type = "submit" value = "edit" name="doThisToItem">
	<input type = "submit" value = "delete" name="doThisToItem">
	<input type="submit" value = "add" name = "doThisToItem">
	</form>
	

</body>
</html>