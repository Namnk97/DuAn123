package googleservlet;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login-out")
public class LoginoutGoogle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginoutGoogle() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("/views/index.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
//		if (session != null) {
		session.setAttribute("user", null);
		// session.removeAttribute("user");
		// session.getMaxInactiveInterval();
		// session.invalidate();
//		RequestDispatcher dis = request.getRequestDispatcher("/views/index.jsp");
//		dis.forward(request, response);
		//response.sendRedirect("http://localhost:8080/Duan123/login-google");
//		}
		//doGet(request, response);
	}

}
