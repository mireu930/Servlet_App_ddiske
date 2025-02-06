package com.root.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import com.root.app.utils.DBConnection;

public class DepartmentDAO {
	
	public List<DepartmentDTO> getList() throws Exception {
		// 1. Connection
		Connection connection = DBConnection.getConnection();		
		// 2. Sql문 생성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID DESC";
		// 3. 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		// 4. ? 처리
		
		// 5. 최종 전송 및 결과 처리
		List<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getLong("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getLong("LOCATION_ID"));
			ar.add(departmentDTO);
		}
		
		// 6. 연결 해제
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}
	
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setLong(1, departmentDTO.getDepartment_id());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			departmentDTO.setDepartment_id(rs.getLong("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getLong("LOCATION_ID"));
		}else {
			departmentDTO = null;
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return departmentDTO;
		
	}
	
	public int add (DepartmentDTO departmentDTO) throws Exception{
		int result = 0;
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)"
				+ " VALUES (DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setLong(3, departmentDTO.getLocation_id());
		
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	
	// 부서 삭제
	public int delete (DepartmentDTO departmentDTO) throws Exception {
		int result = 0;
		Connection connection = DBConnection.getConnection();
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setLong(1, departmentDTO.getDepartment_id());
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	
	// 부서 수정
	public int update (DepartmentDTO departmentDTO) throws Exception {
		int result = 0;
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=?"
				+ " WHERE DEPARTMENT_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setLong(3, departmentDTO.getLocation_id());
		st.setLong(4, departmentDTO.getDepartment_id());
		
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}

}
