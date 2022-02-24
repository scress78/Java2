<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new list</title>
</head>
<body>
	<form action = "CreateNewListServlet" method="post">
		<!-- List Name from ToDoListDetails.java  -->
		List Name: <input type ="text" name = "listName"><br />
		
		<!-- Username from ToDoUser.java -->
		Username: <input type = "text" name = "userName"><br />
		
		<!-- all properties from ToDoItem.java ?  -->		
		Available Items:<br />
		<select name="allItemsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
		 		<option value = "${currentitem.id}">${currentitem.description} | ${currentitem.priority} | ${currentitem.complete}</option>
			</c:forEach>
		</select> <br />
		
		<input type = "submit" value="Create List and Add Items">
	</form>
	<a href = "index.html">Go add new to-do items instead.</a>

</body>
</html>