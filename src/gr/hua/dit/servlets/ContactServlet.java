package gr.hua.dit.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gr.hua.dit.beans.Contact;
import gr.hua.dit.beans.User;

@WebServlet(name = "Contact", urlPatterns = { "/Contact" })
public class ContactServlet extends HttpServlet {

	private static final long serialVersionUID = 6227417619618196810L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pageTitle = "";
		String contact_id = request.getParameter("contact_id");
		String user_id = request.getParameter("user_id");
		try {
			if (contact_id != null) {
				try {
					int id = Integer.parseInt(contact_id);
					int uid = Integer.parseInt(user_id);
					System.out.println("user id " + user_id);
					System.out.println("contact id " + contact_id);

					ps = con.prepareStatement(
							"select id, name, surname, phone, birthdate, user_id from Contacts where id = ? and user_id = ?");
					ps.setString(1, String.valueOf(id));
					ps.setString(2, String.valueOf(uid));
					pageTitle = "My Contacts Page";
				} catch (NumberFormatException e) {
					System.out.println("Wrong number");
				}
				rs = ps.executeQuery();
				if (rs != null && rs.next()) {

					Contact contact = new Contact(rs.getInt("id"), rs.getString("name"), rs.getString("surname"),
							rs.getInt("phone"), rs.getDate("birthdate"), rs.getInt("user_id"));
					HttpSession session = request.getSession();
					session.setAttribute("Contact", contact);
					session.setAttribute("pageTitle", "Contact Page");
					response.sendRedirect("protected/contact.jsp");
				}
				else {
					IOException e = new IOException("You have not acces to change this Contact");
					   throw e;
				}

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
