package com.root.app.tests.connection;

import java.sql.Connection;

import com.root.app.utils.DBConnection;

public class DBConnectionTest {

	public static void main(String[] args) {
		try {
			Connection connection = DBConnection.getConnection();
			
			System.out.println(connection);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
