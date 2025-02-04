package com.root.app.tests.locations;

import java.util.List;

import com.root.app.locations.LocationDAO;
import com.root.app.locations.LocationDTO;

public class LocationDAOTest {

	public static void main(String[] args) {
		LocationDAO locationDAO = new LocationDAO();
		
		try {
			LocationDTO locationDTO = locationDAO.getDetail(1100);
			System.out.println(locationDTO.getCity());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
