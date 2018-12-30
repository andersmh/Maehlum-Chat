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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
		dispatcher.forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DatabaseHandler handler = new DatabaseHandler();
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(handler.exists(username, password)){
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			session.setMaxInactiveInterval(324);
			response.sendRedirect("IndexServlet");
		} else {
			
			HttpSession session = request.getSession();
			session.setAttribute("errorMessage", "Incorrect username/password");
			response.sendRedirect("LoginServlet");
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			//dispatcher.forward(request, response);
			
		}
		
		

	}

}
