package gr.hua.dit.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(
filterName = "AuthenticationFilter",
urlPatterns = { "/protected/*", "/Contacts", "/Contact" }
)

public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("AuthenticationFilter initialized");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		System.out.println("Requested Resource::" + uri);

		HttpSession session = req.getSession(false);

		if (session == null) {
			System.out.println("Unauthorized access request " + uri);
			res.sendRedirect(req.getContextPath() + "/login.html");
		} else {
			// pass the request along the filter chain
			System.out.println("Authorized access request " + uri);
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// close any resources here
	}

}