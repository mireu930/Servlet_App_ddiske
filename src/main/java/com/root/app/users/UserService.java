package com.root.app.users;import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		
		int result = userDAO.join(userDTO);
		
		String str = "가입 실패";
		
		if(result > 0) {
			actionForward.setFlag(false);
			actionForward.setPath("/index.do");
		}else {
			request.setAttribute("result", str);
			request.setAttribute("path", "./join.do");
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		}
		
		
	}
	
	public void login(HttpServletRequest request, ActionForward actionForward)throws Exception {
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserName(request.getParameter("username"));
		userDTO.setPassWord(request.getParameter("password"));
		userDTO = userDAO.login(userDTO);
		
		
		
		if(userDTO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userDTO);
			actionForward.setFlag(false);
			actionForward.setPath("/index.do");
		}else {
			String result = "로그인 실패";
			request.setAttribute("result", result);
			request.setAttribute("path", "./login.do");
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		}
		
	}
	
	public void update(HttpServletRequest request, ActionForward actionForward)throws Exception {
		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
		userDTO.setEmail(request.getParameter("email"));
		userDTO.setName(request.getParameter("name"));
		userDTO.setPhone(request.getParameter("phone"));
		int result = userDAO.update(userDTO);
		String str = "정보 수정 실패";
		
		if(result > 0) {
			str = "정보 수정 성공";
			request.getSession().setAttribute("user", userDAO.login(userDTO));
			actionForward.setFlag(false);
			actionForward.setPath("./mypage.do");
		}else {
			request.setAttribute("result", str);
			request.setAttribute("path", "./update.do");
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		}
		
	}

}
