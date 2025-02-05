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
		
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS";
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		List<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
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
	
	public LocationDTO getDetail(LocationDTO locationDTO) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, locationDTO.getLocation_id());
		ResultSet rs = st.executeQuery();
		
		locationDTO = new LocationDTO();
		
		if(rs.next()) {
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
		}else {
			locationDTO = null;
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return locationDTO;
		
	}

}
