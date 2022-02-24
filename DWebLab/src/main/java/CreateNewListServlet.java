

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ToDoListDetailsHelper;
import controller.ToDoItemHelper;
import model.ToDoListDetails;
import model.ToDoItem;
import model.ToDoUser;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/CreateNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ToDoItemHelper lih = new ToDoItemHelper();
		
		// matches input field in new-list.jsp
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		
		
		//match with parameter in new-list.jsp
		String userName = request.getParameter("userName");
		
		// get all selected items from new-list.jsp
		String[] selectedItems =request.getParameterValues("allItemsToAdd");
		List<ToDoItem> selectedItemsInList = new ArrayList<ToDoItem>();
		
		//make sure something was selected – otherwise we get a nullpointer exception
		if (selectedItems != null && selectedItems.length > 0){
			for(int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ToDoItem c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
				}
		}
		
		// make a new user, assign that user a username
		ToDoUser user = new ToDoUser(userName);
		
		//ToDoListDetails, initialize with the name of the list, and the username? add list items later
		ToDoListDetails sld = new ToDoListDetails(listName, user);
		
		//set the To-List Items, with ToDoListDetails method
		// there is a capitalization error here, it's risky to track it down. Note anyway!
		sld.setlistOfToDoItems(selectedItemsInList);
		
		ToDoListDetailsHelper slh = new ToDoListDetailsHelper();
		
		slh.insertNewListDetails(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
