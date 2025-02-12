package com.root.app.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.root.app.utils.DBConnection;

public class UserDAO {
	
	public int join(UserDTO userDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO USERS (USERNAME, PASSWORD, NAME, PHONE, EMAIL)"
				+ " VALUES (?, ?, ?, ?, ?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, userDTO.getUserName());
		st.setString(2, userDTO.getPassWord());
		st.setString(3, userDTO.getName());
		st.setString(4, userDTO.getPhone());
		st.setString(5, userDTO.getEmail());
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	public UserDTO login(UserDTO userDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM USERS"
				+ " WHERE USERNAME = ? AND PASSWORD = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, userDTO.getUserName());
		st.setString(2, userDTO.getPassWord());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			userDTO.setEmail(rs.getString("email"));
			userDTO.setName(rs.getString("name"));
			userDTO.setPassWord(rs.getString("password"));
			userDTO.setPhone(rs.getString("phone"));
			userDTO.setUserName(rs.getString("username"));
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return userDTO;
		
	}
	
	public int update(UserDTO userDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE INTO USERS SET NAME = ?, EMAIL = ?, PHONE = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, userDTO.getName());
		st.setString(2, userDTO.getEmail());
		st.setString(3, userDTO.getPhone());
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
		
	}

}
