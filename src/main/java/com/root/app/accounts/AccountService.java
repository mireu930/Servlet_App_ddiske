package com.root.app.accounts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;


import com.root.app.ActionFoward;
import com.root.app.users.UserDTO;

public class AccountService {
	
	private AccountDAO accountDAO;
	
	public AccountService() {
		accountDAO = new AccountDAO();
	}
	
	public void getList(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		HttpSession session = request.getSession();
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		
		if(userDTO==null) {
			request.setAttribute("result", "로그인이필요합니다.");
			request.setAttribute("path", "../users/login.do");
			
			actionFoward.setFlag(true);
			actionFoward.setPath("/WEB-INF/views/alert/result.jsp");
			
		}else {
		request.setAttribute("list", accountDAO.getList(userDTO));
		
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/accounts/list.jsp");
		}
	}
	
	public void getDetail(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		String id = request.getParameter("accountNum");
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNum(id);
		accountDTO = accountDAO.getDetail(accountDTO);
		request.setAttribute("dto", accountDTO);
		
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/accounts/detail.jsp");
	}
	
	public void add(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		HttpSession session = request.getSession();
		AccountDTO accountDTO = new AccountDTO();
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		
		if(userDTO == null) {
			request.setAttribute("path", "../users/login.do");
		}else {
		
		accountDTO.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		accountDTO.setUser_name(userDTO.getUser_name());
		
		int result = accountDAO.add(accountDTO);
		
		String message ="추가실패";
		
		if(result>0) {
			message="추가성공";
		}
		
		request.setAttribute("result", message);
		request.setAttribute("path", "./list.do");
		
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/alert/result.jsp");
		}
	}
	
	public void update(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		
		accountDTO.setAccountNum(request.getParameter("accountNum"));
		accountDTO = accountDAO.getDetail(accountDTO);
		
		request.setAttribute("dto", accountDTO);
		
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/accounts/update.jsp");
	}
	
	public void updateProcess(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		
		accountDTO.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		accountDTO.setUser_name(request.getParameter("user_name"));
		accountDTO.setAccountsBalance(Long.parseLong(request.getParameter("accountsBalance")));
//		accountDTO.setAccountDate(Date.valuOf(request.getParameter("accountDate"));
		
		
		int result = accountDAO.update(accountDTO);
		if(result > 0) {
			request.setAttribute("dto", accountDAO.getDetail(accountDTO));
			actionFoward.setFlag(false);
			actionFoward.setPath("./detail.do");
		}else {
			request.setAttribute("result","실패");
			request.setAttribute("path", "./update.do");
			
			actionFoward.setFlag(true);
			actionFoward.setPath("/WEB-INF/views/alert/result.jsp");
		}
	}

}
