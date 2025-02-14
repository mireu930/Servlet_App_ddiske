package com.root.app.accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.root.app.users.UserDTO;
import com.root.app.utils.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class AccountDAO {
	
	public int add(AccountDTO accountDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO ACCOUNTS (ACCOUNTNUM, USERNAME, PRODUCTNUM, ACCOUNTDATE, ACCOUNTBALANCE)"
				+ " VALUES (?, ?, ?, SYSDATE, 0)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, this.random());
		st.setString(2, accountDTO.getUserName());
		st.setLong(3, accountDTO.getProductNum());
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
		
	}
	
	public List<AccountDTO> getList(UserDTO userDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM ACCOUNTS WHERE USERNAME = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, userDTO.getUserName());
		ResultSet rs = st.executeQuery();
		List<AccountDTO> ar = new ArrayList<AccountDTO>();
		
		while(rs.next()) {
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setAccountBalance(rs.getLong("accountbalance"));
			accountDTO.setAccountDate(rs.getDate("accountdate"));
			accountDTO.setAccountNum(rs.getString("accountnum"));
			accountDTO.setProductNum(rs.getLong("productnum"));
			accountDTO.setUserName(rs.getString("username"));
			ar.add(accountDTO);
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}
	
	
	private String random() throws Exception {
		String result = null;
		
		Calendar ca = Calendar.getInstance();
		Object obj = ca.getTimeInMillis();
		result = obj.toString();
		result = result.substring(0, 3)+"-"+result.substring(3, 9)+"-"+result.substring(9);
		
		
		return result;
	}

}
