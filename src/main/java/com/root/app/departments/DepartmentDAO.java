package com.root.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.root.app.utils.DBConnection;

public class DepartmentDAO {
	
	public List<DepartmentDTO> getList() throws Exception {
		System.out.println("부서 리스트 조회");
		// 1. Connection
		Connection connection = DBConnection.getConnection();		
		// 2. Sql문 생성
		String sql = "SELECT * FROM DEPARTMENTS";
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
	
	public void getDetail() {
		System.out.println("부서 정보 조회");
	}

}
