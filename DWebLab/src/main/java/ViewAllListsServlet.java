

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ToDoListDetailsHelper;
import model.ToDoListDetails;

/**
 * Servlet implementation class ViewAllListsServlet
 */
@WebServlet("/ViewAllListsServlet")
public class ViewAllListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllListsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// this class has the methods for getting list information
		ToDoListDetailsHelper slh = new ToDoListDetailsHelper();
		
		
		// this list of lists contains ToDoListDetails info about ListName,UserName and list items!
		List<ToDoListDetails> abc = slh.getLists();
		
		request.setAttribute("allLists", abc);
		if(abc.isEmpty()){
			request.setAttribute("allLists", " ");
		}
		
		getServletContext().getRequestDispatcher("/to-do-list-by-user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
