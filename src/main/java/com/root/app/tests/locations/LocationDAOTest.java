package com.root.app.tests.locations;

import java.util.List;

import com.root.app.locations.LocationDAO;
import com.root.app.locations.LocationDTO;

public class LocationDAOTest {

	public static void main(String[] args) {
		LocationDAO locationDAO = new LocationDAO();
		
		try {
			LocationDTO locationDTO = new LocationDTO();
			List<LocationDTO> ar = locationDAO.getList();
			System.out.println(ar.size());
			for(int i = 0; i < ar.size(); i++) {
				System.out.println(ar.get(i).getLocation_id());
				System.out.println(ar.get(i).getCity());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
