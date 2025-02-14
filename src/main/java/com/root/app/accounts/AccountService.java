package com.root.app.accounts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.root.app.ActionForward;
import com.root.app.users.UserDTO;

public class AccountService {
	
	private AccountDAO accountDAO;
	
	public AccountService() {
		accountDAO = new AccountDAO();
	}
	
	public void add(HttpServletRequest request, ActionForward actionForward) throws Exception {
		HttpSession session = request.getSession();
		AccountDTO accountDTO = new AccountDTO();
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		String str = "로그인 후 이용해주세요";
		if(userDTO == null) {
			request.setAttribute("path", "../users/login.do");
		}else {
			accountDTO.setProductNum(Long.parseLong(request.getParameter("productnum")));
			accountDTO.setUserName(userDTO.getUserName());
			int result = accountDAO.add(accountDTO);
			
			if(result > 0) {
				str = "가입 완료";
				request.setAttribute("path", "../products/list.do");
			}else {
				str = "가입 실패";
				request.setAttribute("path", "../products/detail.do");
			}
		}
		request.setAttribute("result", str);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");	
	}
	
	public void getList(HttpServletRequest request, ActionForward actionForward) throws Exception {
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		request.setAttribute("list", accountDAO.getList(userDTO));
		
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/accounts/list.jsp");
	}
	

}
