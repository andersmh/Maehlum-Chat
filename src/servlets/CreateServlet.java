package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helpers.DatabaseHandler;


@SuppressWarnings("serial")
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/create.jsp");
		dispatcher.forward(request, response);
	
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		DatabaseHandler handler = new DatabaseHandler();
	
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		//String password2 = request.getParameter("password2");
	
		handler.addPerson(firstName, lastName, email, username, password1);
		
		HttpSession session = request.getSession(false);
		session.setAttribute("errorMessage", "Account was created!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("LoginServlet");
		dispatcher.forward(request, response);
	
	}

}
