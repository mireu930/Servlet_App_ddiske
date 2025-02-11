package com.root.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.root.app.utils.DBConnection;

public class EmployeeDAO {
	
	public EmployeeDTO getDetail(EmployeeDTO employeeDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			employeeDTO = new EmployeeDTO();
			employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
			employeeDTO.setDepartment_id(rs.getInt("department_id"));
			employeeDTO.setEmail(rs.getString("email"));
			employeeDTO.setEmployee_id(rs.getInt("employee_id"));
			employeeDTO.setFirst_name(rs.getString("first_name"));
			employeeDTO.setHire_date(rs.getDate("hire_date"));
			employeeDTO.setJob_id(rs.getString("job_id"));
			employeeDTO.setLast_name(rs.getString("last_name"));
			employeeDTO.setManager_id(rs.getInt("manager_id"));
			employeeDTO.setPassword(rs.getString("password"));
			employeeDTO.setPhone_number(rs.getString("phone_number"));
			employeeDTO.setSalary(rs.getDouble("salary"));
		}else {
			employeeDTO = null;
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return employeeDTO;
	}
	
	
	public int add(EmployeeDTO employeeDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID, PASSWORD)"
				+ " VALUES (EMPLOYEES_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, employeeDTO.getFirst_name());
		st.setString(2, employeeDTO.getLast_name());
		st.setString(3, employeeDTO.getEmail());
		st.setString(4, employeeDTO.getPhone_number());
		st.setString(5, employeeDTO.getJob_id());
		st.setDouble(6, employeeDTO.getSalary());
		st.setDouble(7, employeeDTO.getCommission_pct());
		st.setInt(8, employeeDTO.getManager_id());
		st.setInt(9, employeeDTO.getDepartment_id());
		st.setString(10, employeeDTO.getPassword());
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	public EmployeeDTO login(EmployeeDTO employeeDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT FIRST_NAME, PASSWORD, EMPLOYEE_ID FROM EMPLOYEES"
				+ " WHERE EMPLOYEE_ID = ? AND PASSWORD = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, employeeDTO.getEmployee_id());
		st.setString(2, employeeDTO.getPassword());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			employeeDTO.setFirst_name(rs.getString("first_name"));
		}else {
			employeeDTO = null;
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return employeeDTO;
		
	}

}
