package com.root.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.root.app.departments.DepartmentDTO;
import com.root.app.utils.DBConnection;

public class LocationDAO {
	
	public List<LocationDTO> getList() throws Exception {
		System.out.println("지역 리스트 조회");
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS";
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		LocationDTO locationDTO = new LocationDTO();
		List<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		while(rs.next()) {
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			ar.add(locationDTO);
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
		
	}
	
	public LocationDTO getDetail(int data) throws Exception {
		System.out.println("지역 정보 조회");
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, data);
		ResultSet rs = st.executeQuery();
		
		LocationDTO locationDTO = new LocationDTO();
		
		if(rs.next()) {
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
		}else {
			System.out.println("해당 정보 없음");
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return locationDTO;
		
	}

}
