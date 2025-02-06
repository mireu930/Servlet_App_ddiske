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
	
	public int add(LocationDTO locationDTO) throws Exception {
		int result = 0;
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO LOCATIONS(LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID)"
				+ " VALUES (LOCATIONS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setString(3, locationDTO.getCity());
		st.setString(4, locationDTO.getState_province());
		st.setString(5, locationDTO.getCountry_id());
		
		result = st.executeUpdate();
		
		return result;
	}
	
	
	public int delete(LocationDTO locationDTO) throws Exception {
		int result = 0;
		Connection connection = DBConnection.getConnection();
		String sql = "DELETE LOCATIONS WHERE LOCATION_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, locationDTO.getLocation_id());
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}
	
	
	public int update(LocationDTO locationDTO) throws Exception {
		int result = 0;
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE LOCATIONS SET STREET_ADDRESS = ?, POSTAL_CODE = ?, STATE_PROVINCE = ?,"
				+ " CITY = ?, COUNTRY_ID = ? WHERE LOCATION_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setString(3, locationDTO.getState_province());
		st.setString(4, locationDTO.getCity());
		st.setString(5, locationDTO.getCountry_id());
		st.setInt(6, locationDTO.getLocation_id());
		
		result = st.executeUpdate();
		
		return result;
	}

}
