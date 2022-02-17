package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ToDoItem;



/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    // additemServlet main/java/controller
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String description = request.getParameter("description");
		String priority = request.getParameter("priority");
		String complete = request.getParameter("complete");

		
		ToDoItem li = new ToDoItem(description, priority, complete);
		
		ToDoItemHelper dao = new ToDoItemHelper();
		
		dao.insertItem(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);

	}

}
