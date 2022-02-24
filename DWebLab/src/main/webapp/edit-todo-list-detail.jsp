<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Existing List</title>
</head>
<body>

<!-- path index > ViewAllListsServlet > to-do-list-by-user > ListNavigationServlet(edit) > 
	edit-todo-list-detail.jsp -->
<!-- edits the elements of a to-do list object.. ie the ListName and UserName and items on a To-Do List object-->

	<form action = "EditListDetailsServlet" method="post">
		<input type ="hidden" name = "id" value= "${listToEdit.id}">
			List Name: <input type ="text" name = "listName" value="${listToEdit.listName}"><br />
			
			Username: <input type = "text" name = "userName" value="${listToEdit.toDoUser.userName}"><br />
		
		Available Items:<br />
		<select name="allItemsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
			 <option value = "${currentitem.id}">${currentitem.description} | ${currentitem.priority}</option>
			</c:forEach>
		</select><br />
		<input type = "submit" value="Edit List and Add Items">
	</form>
<a href = "index.html">Go add new items instead.</a>

</body>
</html>