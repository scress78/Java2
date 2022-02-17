package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ToDoItem;

/**
 * Servlet implementation class EditToDoServlet
 */
@WebServlet("/EditToDoServlet")
public class EditToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditToDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ToDoItemHelper dao = new ToDoItemHelper();
		String description = request.getParameter("description");
		String priority = request.getParameter("priority");
		String complete = request.getParameter("complete");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ToDoItem itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setDescription(description);
		itemToUpdate.setPriority(priority);
		itemToUpdate.setComplete(complete);
		dao.updateItem(itemToUpdate);
		getServletContext().getRequestDispatcher("/ViewAllToDoServlet").forward(request, response);
		
		
		//doGet(request, response);
	}

}
