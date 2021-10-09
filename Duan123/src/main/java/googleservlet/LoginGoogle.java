package googleservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accessgoogle.GooglePojo;
import accessgoogle.GoogleUtils;
import accessgoogle.SaveClient;
import accessgoogle.User;
import accessgoogle.UserServies;

@WebServlet("/login-google")
public class LoginGoogle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServies userLogin;

	public LoginGoogle() {
		this.userLogin = new UserServies();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()) {
//			request.setAttribute("path", request.getContextPath());
//			request.setAttribute("URI", SaveClient.GOOGLE_REDIRECT_URI);
//			request.setAttribute("ID", SaveClient.GOOGLE_CLIENT_ID);
			RequestDispatcher dis = request.getRequestDispatcher("/views/login.jsp");
			dis.forward(request, response);
			return;
		}
		String token = GoogleUtils.getToken(code);
		GooglePojo googlePojo = GoogleUtils.getUserInfo(token);
		// request.getSession().setAttribute("googlePojo", googlePojo);

		String email = googlePojo.getEmail();
		User us = userLogin.findByEmail(email);
		if (us != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", us);
			// request.setAttribute("email", email);
			// session.setMaxInactiveInterval(30);
//			RequestDispatcher dis = request.getRequestDispatcher("/views/index.jsp");
//			dis.forward(request, response);

			response.sendRedirect("http://localhost:8080/Duan123/Login-out");
		} else {
			RequestDispatcher dis = request.getRequestDispatcher("/views/login.jsp");
			dis.forward(request, response);
			response.sendRedirect("http://localhost:8080/Duan123/login-google");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private boolean Login(String gmail) {
		User us = this.userLogin.findByEmail(gmail);
		return us != null;
	}

}
