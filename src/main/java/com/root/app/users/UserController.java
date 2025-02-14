package com.root.app.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.root.app.ActionFoward;

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
        // TODO Auto-generated constructor stub
        userService = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("userController");
		
		String uri = request.getRequestURI();
		
		uri = uri.substring(uri.lastIndexOf("/")+1);
		
		ActionFoward actionFoward = new ActionFoward();
		
		try {
			if(uri.equals("join.do")) {
				String method = request.getMethod();
				
				if(method.toUpperCase().equals("POST")) {
					userService.add(request, actionFoward);
				} else {
					actionFoward.setFlag(true);
					actionFoward.setPath("/WEB-INF/views/users/add.jsp");
				}
			} else if(uri.equals("login.do")) {
				String method = request.getMethod();
				
				Cookie [] cookies = request.getCookies();
				
				for(Cookie cookie:cookies) {
					System.out.println(cookie.getName());
					System.out.println(cookie.getValue());
				}
				
				
				if(method.toUpperCase().equals("POST")) {
					userService.login(request, actionFoward);
				}else {
					actionFoward.setFlag(true);
					actionFoward.setPath("/WEB-INF/views/users/login.jsp");
				}
				
			} else if(uri.equals("logout.do")) {
				HttpSession session = request.getSession();
				
				session.invalidate();
				actionFoward.setFlag(false);
				actionFoward.setPath("../index.do");
				
			} else if(uri.equals("mypage.do")) {
				
				actionFoward.setFlag(true);
				actionFoward.setPath("/WEB-INF/views/users/mypage.jsp");
			} else if(uri.equals("update.do")) {
				String method = request.getMethod();
				
				if(method.toUpperCase().equals("POST")) {
					userService.update(request, actionFoward);
				} else {
					
					actionFoward.setFlag(true);
					actionFoward.setPath("/WEB-INF/views/users/update.jsp");
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(actionFoward.isFlag()) {
			RequestDispatcher view = request.getRequestDispatcher(actionFoward.getPath());
			view.forward(request, response);	
		} else {
			response.sendRedirect(actionFoward.getPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
