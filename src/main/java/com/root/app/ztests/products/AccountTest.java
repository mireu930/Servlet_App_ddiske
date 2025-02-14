package com.root.app.ztests.products;

import java.util.List;

import com.root.app.accounts.AccountDAO;
import com.root.app.accounts.AccountDTO;
import com.root.app.users.UserDTO;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			AccountDAO accountDAO = new AccountDAO();
			
			UserDTO userDTO = new UserDTO();
			
			userDTO.setUser_name("sss");
			List<AccountDTO> ar = accountDAO.getList(userDTO);
						
			System.out.println(ar.get(0).getAccountNum());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
