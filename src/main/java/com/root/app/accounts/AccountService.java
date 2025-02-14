package com.root.app.accounts;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


import com.root.app.ActionFoward;

public class AccountService {
	
	private AccountDAO accountDAO;
	
	public AccountService() {
		accountDAO = new AccountDAO();
	}
	
	public ActionFoward getList(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		List<AccountDTO> ar = accountDAO.getList();
		
		request.setAttribute("list", ar);
		
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/accounts/list.jsp");
		
		return actionFoward;
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
		AccountDTO accountDTO = new AccountDTO();
		
		accountDTO.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		accountDTO.setUser_name(request.getParameter("user_name"));
		
		int result = accountDAO.add(accountDTO);
		
		actionFoward.setFlag(false);
		actionFoward.setPath("./list.do");
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
		
			actionFoward.setFlag(false);
			actionFoward.setPath("./detail.do");
	}

}
