package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NumberAdder;

/**
 * Servlet implementation class getAdditionServlet
 */
@WebServlet("/getAdditionServlet")
public class getAdditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAdditionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String numOne = request.getParameter("userNumberOne");
		String numTwo = request.getParameter("userNumberTwo");
		
		NumberAdder result = new NumberAdder(Integer.parseInt(numOne), Integer.parseInt(numTwo));
		
		//uRes = UserResults. Much easier to read html with abbreviated variable
		request.setAttribute("uRes", result);
		
		getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
		
		//PrintWriter writer = response.getWriter();
		//writer.println("You entered " + userAdditionOne.toString() + " and "+ userAdditionTwo.toString() +".");
		//writer.println(result.toString());
		//writer.close();
	}

}
