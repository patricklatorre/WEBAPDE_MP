package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import services.PasswordService;
import services.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(urlPatterns={"/RegisterServlet", "/register"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		System.out.println("Registering user...");
		
		String username = request.getParameter("reg_username");
		System.out.println("username");
		String password = request.getParameter("reg_password");
		String description = request.getParameter("reg_description");
		
		User user;
		if(!UserService.userExists(username)) {
			System.out.println("User does not exist.");
			user = new User();
			user.setUsername(username);
			user.setDescription(description);
			
			UserService.addUser(user);
			System.out.println("Setting password...");
			System.out.println("User ID: " + UserService.getUserIdByUsername(username));
			System.out.println("Password: " + password);
			
			PasswordService.setPassword(UserService.getUserIdByUsername(username), password);
			
			Cookie userCookie = new Cookie("username", username);
			userCookie.setMaxAge(60*60*24*365);
			userCookie.setHttpOnly(true);
			response.addCookie(userCookie);
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		} else {
			System.out.print("User exists.");
			request.setAttribute("message", "This username is already being used.");
			request.getRequestDispatcher("index.jsp");
		}
	}

}
