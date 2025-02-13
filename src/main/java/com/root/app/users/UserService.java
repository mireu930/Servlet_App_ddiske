package com.root.app.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.root.app.ActionFoward;

public class UserService {
	private UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	public void login(HttpServletRequest request, ActionFoward actionFoward) throws Exception  {
		UserDTO userDTO = new UserDTO();
		userDTO.setUser_name(request.getParameter("user_name"));
		userDTO.setPassword(request.getParameter("password"));
		
		userDTO = userDAO.login(userDTO);
		
		HttpSession session = request.getSession();
		
		if(userDTO != null) {
		session.setAttribute("user", userDTO);
		
		actionFoward.setFlag(false);
		actionFoward.setPath("../index.do");
		} else {
			request.setAttribute("result", "로그인실패");
			request.setAttribute("path", "./login.do");
			
			actionFoward.setFlag(true);
			actionFoward.setPath("/WEB-INF/views/alert/result.jsp");
		}
		
		
	}
	
	public void add(HttpServletRequest request, ActionFoward actionFoward) throws Exception  {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUser_name(request.getParameter("user_name"));
		userDTO.setPassword(request.getParameter("password"));
		userDTO.setName(request.getParameter("name"));
		userDTO.setPhone(request.getParameter("phone"));
		userDTO.setEmail(request.getParameter("email"));
		
		int result = userDAO.add(userDTO);
		
		if(result>0) {
			actionFoward.setFlag(false);
			actionFoward.setPath("../index.do");			
		} else {
			request.setAttribute("result", "가입실패");
			request.setAttribute("path", "./join.do");
			
			actionFoward.setFlag(true);
			actionFoward.setPath("/WEB-INF/views/alert/result.jsp");
		}
		
	}
	
	public void update(HttpServletRequest request, ActionFoward actionFoward) throws Exception  {
		
	}

}
