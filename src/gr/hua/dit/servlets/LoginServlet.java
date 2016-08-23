package gr.hua.dit.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gr.hua.dit.beans.User;

@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 8345605719292191551L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		String errorMsg = null;
		if (email == null || email.equals("")) {
			errorMsg = "User Email can't be null or empty";
		}
		if (password == null || password.equals("")) {
			errorMsg = "Password can't be null or empty";
		}

		if (errorMsg != null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>" + errorMsg + "</font>");
			rd.include(request, response);
		} else {

			Connection con = (Connection) getServletContext().getAttribute("DBConnection");
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(
						"select id, name, email,country from Users where email=? and password=? limit 1");
				ps.setString(1, email);
				ps.setString(2, password);
				rs = ps.executeQuery();

				if (rs != null && rs.next()) {

					User user = new User(rs.getString("name"), rs.getString("email"), rs.getString("country"),
							rs.getInt("id"));
					HttpSession session = request.getSession();
					session.setAttribute("User", user);
					response.sendRedirect("protected/home.jsp");
				} else {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
					PrintWriter out = response.getWriter();
					System.out.println("User not found with email=" + email);
					out.println("<font color=red>No user found with given email id, please register first.</font>");
					rd.include(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Database connection problem");
				throw new ServletException("DB Connection problem.");
			} finally {
				try {
					rs.close();
					ps.close();
				} catch (SQLException e) {
					System.out.println("SQLException in closing PreparedStatement or ResultSet");
				}

			}
		}
	}

}
