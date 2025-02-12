package com.root.app.accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.root.app.products.ProductDTO;
import com.root.app.tests.connection.DBConnectionTest;

public class AccountDAO {
	
	public List<AccountDTO> getList() throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM ACCOUNTS ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		List<AccountDTO> ar = new ArrayList();
		
		while(resultSet.next(){
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setAccountNum(resultSet.getString(1));
			accountDTO.setProductNum(resultSet.getInt(2));
			accountDTO.setUser_name(resultSet.getString(3));
			accountDTO.setAccountsBalance(resultSet.getLong(4));
			accountDTO.setAccountDate(resultSet.getDate(5));
			
			ar.add(accountDTO);
		}
		
		DBConnection.disConnect(resultSet, preparedStatement, connection);
		
		return ar;
	}
	
	public AccountDTO getDetail(AccountDTO accountDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM ACCOUNTS WHERE ACCOUNTNUM = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, accountDTO.getAccountNum());
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()){
			accountDTO.setAccountNum(resultSet.getString(1));
			accountDTO.setProductNum(resultSet.getInt(2));
			accountDTO.setUser_name(resultSet.getString(3));
			accountDTO.setAccountsBalance(resultSet.getLong(4));
			accountDTO.setAccountDate(resultSet.getDate(5));
		} else {
			accountDTO = null;
		}
		
		DBConnection.disConnect(resultSet, preparedStatement, connection);
		
		return accountDTO;
	}

	public int add(AccountDTO accountDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO ACCOUNTS\r\n"
				+ "VALUES (?,?,?,0,SYSDATE)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		StringBuilder sb = new StringBuilder();
		Calendar calendar = Calendar.getInstance();
		sb.append(calendar.get(calendar.YEAR));
		sb.append(calendar.get(calendar.MONTH)+1);
		sb.append(calendar.get(calendar.DATE));
		sb.append("-");
		sb.append(calendar.get(calendar.HOUR_OF_DAY));
		sb.append(calendar.get(calendar.MINUTE));
		sb.append(calendar.get(calendar.SECOND));
		sb.append(calendar.get(calendar.MILLISECOND));
		
		accountDTO.setAccountNum(sb.toString());

		preparedStatement.setString(1, accountDTO.getAccountNum());
		preparedStatement.setInt(2, accountDTO.getProductNum());
		preparedStatement.setString(3, accountDTO.getUser_name());
		
		int result = preparedStatement.executeUpdate();
		
		DBConnection.disConnect(preparedStatement, connection);
		
		return result;
	}
	
	public int update(AccountDTO accountDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE ACCOUNTS SET PRODUCTNUM=?,USER_NAME=?,ACCOUNTBALANCE=?,ACCOUNTDATE=? "
				+ "WHERE ACCOUNTNUM=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, accountDTO.getProductNum());
		preparedStatement.setString(2, accountDTO.getUser_name());
		preparedStatement.setLong(3, accountDTO.getAccountsBalance());
		preparedStatement.setDate(4, accountDTO.getAccountDate());
		preparedStatement.setString(5, accountDTO.getAccountNum());
		
		int result = preparedStatement.executeUpdate();
		
		DBConnection.disConnect(preparedStatement, connection);
		
		return result;
	}
}
