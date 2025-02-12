package com.root.app.users;import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import com.root.app.ActionForward;

public class UserService {
	
	private UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	public void join(HttpServletRequest request, ActionForward actionForward) throws Exception {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setEmail(request.getParameter("email"));
		userDTO.setName(request.getParameter("name"));
		userDTO.setPassWord(request.getParameter("password"));
		userDTO.setPhone(request.getParameter("phone"));
		userDTO.setUserName(request.getParameter("username"));
		
		userDAO.join(userDTO);
		
	}
	
	public void login(HttpServletRequest request, ActionForward actionForward)throws Exception {
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserName(request.getParameter("username"));
		userDTO.setPassWord(request.getParameter("password"));
		userDTO = userDAO.login(userDTO);
		
		
	}

}
