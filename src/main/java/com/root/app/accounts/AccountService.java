package com.root.app.accounts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.root.app.ActionForward;

public class AccountService {
	
	private AccountDAO accountDAO;
	
	public AccountService() {
		accountDAO = new AccountDAO();
	}
	
	public void add(HttpServletRequest request, ActionForward actionForward) throws Exception {
		HttpSession session = request.getSession();
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setProductNum(Long.parseLong(request.getParameter("productNum")));
		accountDTO.setUserName((String)session.getAttribute("user"));
		int result = accountDAO.add(accountDTO);
		String str = "가입 실패";
		
		if(result > 0) {
			str = "가입 완료";
		}
		request.setAttribute("result", str);
		request.setAttribute("path", "../products/list.do");
		actionForward.setFlag(false);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		
	}

}
