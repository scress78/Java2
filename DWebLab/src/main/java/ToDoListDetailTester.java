/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 22, 2022
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import controller.ToDoListDetailsHelper;
import model.ToDoItem;
import model.ToDoListDetails;
import model.ToDoUser;




public class ToDoListDetailTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ToDoUser cameron = new ToDoUser("Cameron");
		//ToDoUserHelper sh = new ToDoUserHelper();
		//sh.insertToDoUser(cameron);
		
		ToDoListDetailsHelper ldh = new ToDoListDetailsHelper();
		
		ToDoItem homework = new ToDoItem("Do Homework", "High", "No");
		ToDoItem github = new ToDoItem("Upload to Github", "Medium", "Complete");
		ToDoItem cleanup = new ToDoItem("Clean Up Project", "Medium", "Complete");
		ToDoItem fixError = new ToDoItem("Fix Entity Error in Project", "Medium", "Complete");
		
		List<ToDoItem> cameronsItems = new ArrayList<ToDoItem>();
		cameronsItems.add(homework);
		cameronsItems.add(github);
		cameronsItems.add(cleanup);
		cameronsItems.add(fixError);
		
		ToDoListDetails cameronsList = new ToDoListDetails("Cameron's List", cameron);
		cameronsList.setlistOfToDoItems(cameronsItems);

		ldh.insertNewListDetails(cameronsList);
		
		List<ToDoListDetails> allLists = ldh.getLists();
		for (ToDoListDetails a : allLists) {
			System.out.println(a.toString());
		}

	}

}
