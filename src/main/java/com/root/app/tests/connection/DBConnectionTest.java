package com.root.app.tests.connection;

import java.sql.Connection;

import com.root.app.utls.DBConnection;

public class DBConnectionTest {

	public static void main(String[] args) {
		try {
			Connection connection = DBConnection.getConnection();
			
			if(connection != null) {
				System.out.println("통과");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
