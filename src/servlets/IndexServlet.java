package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helpers.DatabaseHandler;
import objects.Message;

@SuppressWarnings("serial")
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("username") != null) {

			DatabaseHandler handler = new DatabaseHandler();
			List<Message> list = handler.getMessages();
			session.setAttribute("viewMessages", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
			dispatcher.forward(request, response);

		} else {

			response.sendRedirect("LoginServlet");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		DatabaseHandler handler = new DatabaseHandler();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		String sender = (String) session.getAttribute("username");
		String date = dtf.format(now).toString();
		String inputMessage = request.getParameter("message");

		if (!inputMessage.equals("")) {
			handler.addMessage(sender, date, inputMessage);
		}
		response.sendRedirect("IndexServlet");

	}

}
