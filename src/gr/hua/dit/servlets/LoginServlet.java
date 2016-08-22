package gr.hua.dit.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 8345605719292191551L;
	private static final Map<String, String> userDatabase = new Hashtable<>();

	static {
		userDatabase.put("user1", "user1pass");
		userDatabase.put("user2", "user2pass");
		userDatabase.put("user3", "user3pass");
		userDatabase.put("user4", "user4pass");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get request parameters for username and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");

		if (LoginServlet.userDatabase.containsKey(user) && (pwd.equals(LoginServlet.userDatabase.get(user)))) {
			// if username and password match, create a new session
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// setting session to expiry in 30nai mins
			session.setMaxInactiveInterval(30 * 60);
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(30 * 60);
			response.addCookie(userName);
			response.sendRedirect("LoginSuccess.jsp");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}

	}

}
