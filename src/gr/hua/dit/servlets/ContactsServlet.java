package gr.hua.dit.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gr.hua.dit.beans.Contact;

@WebServlet(name = "Contacts", urlPatterns = { "/Contacts" })
public class ContactsServlet extends HttpServlet {

	private static final long serialVersionUID = -1955768216994179457L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pageTitle="";
		try {
			String user_id = request.getParameter("user_id");

			if (user_id != null) {
				try {
					int id = Integer.parseInt(user_id);
					ps = con.prepareStatement(
							"select id, name, surname, phone, birthdate, user_id from Contacts where user_id = ?");
					ps.setString(1, String.valueOf(id));
					pageTitle="My Contacts Page";
				} catch (NumberFormatException e) {
					System.out.println("Wrong number");
				}
			} else {
				ps = con.prepareStatement("select id, name, surname, phone, birthdate, user_id from Contacts");
				pageTitle="Contacts Page";
			}
			rs = ps.executeQuery();

			ArrayList<Contact> Contacts = new ArrayList<Contact>();
			while (rs.next()) {
				Contact contact = new Contact(rs.getInt("id"), rs.getString("name"), rs.getString("surname"),
						rs.getInt("phone"), rs.getDate("birthdate"), rs.getInt("user_id"));
				Contacts.add(contact);

			}
			System.out.println(Contacts.size());

			HttpSession session = request.getSession();
			session.setAttribute("Contacts", Contacts);
			session.setAttribute("pageTitle", pageTitle);
			response.sendRedirect("protected/contacts.jsp");

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
