package com.root.app.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.root.app.utils.DBConnection;

public class UserDAO {

	public UserDTO login(UserDTO userDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM USERS WHERE USER_NAME=? AND PASSWORD=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, userDTO.getUser_name());
		preparedStatement.setString(2, userDTO.getPassword());
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			
		} else {
			userDTO = null;
		}
		
		DBConnection.disConnect(resultSet, preparedStatement, connection);
		
		return userDTO;
	}
	
	public int add(UserDTO userDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO USERS "
				+ "VALUES (?,?,?,?,?) ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, userDTO.getUser_name());
		preparedStatement.setString(2, userDTO.getPassword());
		preparedStatement.setString(3, userDTO.getName());
		preparedStatement.setString(4, userDTO.getPhone());
		preparedStatement.setString(5, userDTO.getEmail());
		
		int result = preparedStatement.executeUpdate();
		
		DBConnection.disConnect(preparedStatement, connection);
		
		return result;
	}
	
	public int update(UserDTO userDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE USERS SET USER_NAME=?,PASSWORD=?,NAME=?,PHONE=?,EMAIL=?"
				+ "WHERE USER_NAME = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, userDTO.getUser_name());
		preparedStatement.setString(2, userDTO.getPassword());
		preparedStatement.setString(3, userDTO.getName());
		preparedStatement.setString(4, userDTO.getPhone());
		preparedStatement.setString(5, userDTO.getEmail());
		preparedStatement.setString(6, userDTO.getUser_name());
		
		int result = preparedStatement.executeUpdate();
		
		DBConnection.disConnect(preparedStatement, connection);
		
		return result;
	}
}
