package com.root.app.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.root.app.ActionForward;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        userService = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward actionForward = new ActionForward();
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		
		try {
			switch (uri) {
			case "join.do":
				String method = request.getMethod();
				if(method.equalsIgnoreCase("post")) {
					userService.join(request, actionForward);					
				}else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/users/join.jsp");
				}
				break;

			case "login.do" :
				method = request.getMethod();
				if(method.equalsIgnoreCase("post")) {
					userService.login(request, actionForward);
				}else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/users/login.jsp");
				}
				break;
			case "mypage.do" :
				actionForward.setFlag(true);
				actionForward.setPath("/WEB-INF/views/users/mypage.jsp");
				break;
			case "update.do" :
				method = request.getMethod();
				if(method.equalsIgnoreCase("post")) {
					userService.update(request, actionForward);
				}else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/users/update.jsp");
				}
				break;
			case "logout.do" :
				HttpSession session = request.getSession();
				session.invalidate();
				break;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
