package com.root.app.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.root.app.utils.DBConnection;

public class EmployeeDAO {
	
	public EmployeeDTO getDetail(EmployeeDTO employeeDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT employee_id, password, first_name FROM EMPLOYEES WHERE EMPLOYEE_ID = ? AND PASSWORD = ? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, employeeDTO.getEmployee_id());
		statement.setString(2, employeeDTO.getPassword());
		
		ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()) {
			employeeDTO.setFirtst_name(resultSet.getString(1));
		} else {
			employeeDTO = null;
		}
		
		DBConnection.disConnect(resultSet, statement, connection);
		
		return employeeDTO;
	}

	public int add(EmployeeDTO employeeDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID,DEPARTMENT_ID, PASSWORD)\r\n"
				+ "	VALUES(EMPLOYEES_SEQ.NEXTVAL,?,?,?,?,SYSDATE,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, employeeDTO.getEmployee_id());
		statement.setString(2, employeeDTO.getFirtst_name());
		statement.setString(3, employeeDTO.getLast_name());
		statement.setString(4, employeeDTO.getEmail());
		statement.setString(5, employeeDTO.getPhone_number());
		statement.setDate(6, employeeDTO.getHire_date());
		statement.setString(7, employeeDTO.getJob_id());
		statement.setDouble(8, employeeDTO.getSalary());
		statement.setDouble(9, employeeDTO.getCommision());
		statement.setInt(10, employeeDTO.getManager_id());
		statement.setInt(11, employeeDTO.getDepartment_id());
		statement.setString(12, employeeDTO.getPassword());
		
		int result = statement.executeUpdate();
		
		DBConnection.disConnect(statement, connection);
		
		return result;
		
	}
	
	public int delete(EmployeeDTO employeeDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "DELETE EMPLOYEES WHERE employee_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, employeeDTO.getDepartment_id());
		
		int result = statement.executeUpdate();
		
		return result;
	}
	
	public void update() {
		
	}
	
}
