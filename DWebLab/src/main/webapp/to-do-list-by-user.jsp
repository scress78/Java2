<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To-Do Lists</title>
</head>
<body>
	<!-- Configure this servlet! -->
	<form method = "post" action = "ListNavigationServlet">
	
		<!-- all information populated from ToDoListDetails -->
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentlist">
		 
			<tr>
				 <td><input type="radio" name="id" value="${currentlist.id}"></td>
				 <td><h2>${currentlist.listName}</h2></td>
			</tr>
			
			<!-- from ToDoListDetails access the user, 'toDoUser' (ToDoUser.java) and then their name userName -->
			<tr><td colspan="3">Username: ${currentlist.toDoUser.userName}</td></tr>
				 
			 <c:forEach var = "listVal" items = "${currentlist.listOfToDoItems}">
				 <tr>
				 	<td></td>
				 	<td colspan="4"> ${listVal.description}, ${listVal.priority}, ${listVal.complete} </td> 
				 </tr>
		 	</c:forEach>
			</c:forEach>
		</table>
		
		<input type = "submit" value = "edit" name="doThisToList">
		<input type = "submit" value = "delete" name="doThisToList">
		<input type="submit" value = "add" name = "doThisToList">
	</form>
<a href="AddItemsForListServlet">Create a new List</a>
<a href="index.html">Insert a new item</a>

</body>
</html>