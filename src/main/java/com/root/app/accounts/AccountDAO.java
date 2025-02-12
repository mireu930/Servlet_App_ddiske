package com.root.app.accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

import com.root.app.utils.DBConnection;

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
	
	
	private String random() throws Exception {
		String result = null;
		
		Calendar ca = Calendar.getInstance();
		Object obj = ca.getTimeInMillis();
		result = obj.toString();
		result = result.substring(0, 3)+"-"+result.substring(3, 9)+"-"+result.substring(9);
		
		
		return result;
	}

}
