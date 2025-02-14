package com.root.app.users;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.root.app.ActionFoward;

public class UserService {
	private UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	public void detail(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
		
		UserDTO result = userDAO.login(userDTO);
		request.setAttribute("user2", result);
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
		UserDTO session = (UserDTO)request.getSession().getAttribute("user");
//		UserDTO userDTO = new UserDTO();
		
		session.setUser_name(request.getParameter("user_name"));
		session.setPassword(request.getParameter("password"));
		session.setName(request.getParameter("name"));
		session.setPhone(request.getParameter("phone"));
		session.setEmail(request.getParameter("email"));
		session.setUser_name(session.getUser_name());
		
		int result = userDAO.update(session);
		System.out.println(result);
		if(result > 0) {
			request.getSession().setAttribute("user2", userDAO.login(session));
		}
		
		actionFoward.setFlag(false);
		actionFoward.setPath("./mypage.do");
	}

}
