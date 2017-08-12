package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.PasswordService;
import services.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns={"/LoginServlet", "/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("login_username");
		String password = request.getParameter("login_passord");
		
		System.out.println("Attempting to log in...");
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		
		if(UserService.userExists(username)) {
			System.out.println("User found. Comparing password...");
			if(PasswordService.passwordMatches(UserService.getUserIdByUsername(username), password)) {
				// go to main screen and set cookie for user
				Cookie userCookie = new Cookie("username", username);
				userCookie.setMaxAge(60*60*24*365);
				userCookie.setHttpOnly(true);
				response.addCookie(userCookie);
				
				HttpSession session = request.getSession();
				
				session.setAttribute("username", username);

				System.out.println("Password match.");
				System.out.println("Login successful");
				
				request.getRequestDispatcher("profile.jsp").forward(request, response);
			} else {
				// inform user that password is incorrect
				System.out.println("Password incorrect.");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else {
			// inform user that username is not registered
			System.out.println("Username not registered.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}		
	}

}
