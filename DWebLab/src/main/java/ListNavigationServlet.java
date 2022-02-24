

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ToDoListDetailsHelper;
import controller.ToDoItemHelper;
import model.ToDoListDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/ListNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//methods for going through lists
		ToDoListDetailsHelper dao = new ToDoListDetailsHelper();
		
		String act = request.getParameter("doThisToList");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ToDoListDetails listToDelete = dao.searchForListDetailsById(tempId);
				dao.deleteList(listToDelete);
				
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
			}
		} else if (act.equals("edit")) {
			try {
				
				// from to-do-list-by-user.jsp
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ToDoListDetails listToEdit = dao.searchForListDetailsById(tempId);
				
				// need methods from ToDoListDetailsHelper
				request.setAttribute("listToEdit", listToEdit);
				
				// sets attributes in edit-todo-list-detail.jsp
				request.setAttribute("listName", listToEdit.getListName());
				request.setAttribute("userName", listToEdit.getToDoUser().getUserName());
				
				ToDoItemHelper daoForItems = new ToDoItemHelper();
				
				request.setAttribute("allItems", daoForItems.showAllItems());
				if(daoForItems.showAllItems().isEmpty()){
					request.setAttribute("allItems", " ");
				}
				

				// need one final .jsp if this is going to work
				getServletContext().getRequestDispatcher("/edit-todo-list-detail.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
			}
			
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
