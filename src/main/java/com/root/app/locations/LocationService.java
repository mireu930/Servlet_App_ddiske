package com.root.app.locations;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.root.app.ActionFoward;

public class LocationService {
	private LocationDAO locationDAO;
	
	public LocationService() {
		this.locationDAO = new LocationDAO();
	}
	
	public ActionFoward getList(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		List<LocationDTO> ar = locationDAO.getList();
		request.setAttribute("list", ar);
		
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/locations/locationList.jsp");
		
		return actionFoward;
	}
	
	public ActionFoward getDetail(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		String id = request.getParameter("location_id");
		LocationDTO locationDTO = new LocationDTO();
		
		locationDTO.setLocation_id(Integer.parseInt(id));
		locationDTO = locationDAO.getDetail(locationDTO);
		request.setAttribute("dto", locationDTO);
		
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/locations/locationDetail.jsp");
		
		return actionFoward;
	}
	
	public void add(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
    	
    	String address = request.getParameter("street_address");
    	String code = request.getParameter("postal_code");
    	String city = request.getParameter("city");
    	
    	locationDTO.setStreet_address(address);
    	locationDTO.setPostal_code(code);
    	locationDTO.setCity(city);
    	
    	int result = locationDAO.add(locationDTO);
    	
    	String message = "실패";
    	
    	if(result>0) {
    		message = "추가성공";
    	}
    	
    	request.setAttribute("result", message);
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/common/result2.jsp");
    	
	}
	public void update(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		
		String id = request.getParameter("location_id");
		locationDTO.setLocation_id(Integer.parseInt(id));
		locationDTO = locationDAO.getDetail(locationDTO);
		
		request.setAttribute("dto", locationDTO);
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/locations/locationUpdate.jsp");
	}
	
	public void updateProcess(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		
		String address = request.getParameter("street_address");
    	String code = request.getParameter("postal_code");
    	String city = request.getParameter("city");
    	
    	locationDTO.setStreet_address(address);
    	locationDTO.setPostal_code(code);
    	locationDTO.setCity(city);
    
    	int result = locationDAO.update(locationDTO);
    	
    	String message = "실패";
    	
    	if(result>0) {
    		message = "수정성공";
    	}
	}
	
	public void delete(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		
		String id = request.getParameter("location_id");
		
		locationDTO.setLocation_id(Integer.parseInt(id));
		
		int result = locationDAO.delete(locationDTO);
		
		String message = "실패";
    	
    	if(result>0) {
    		message = "삭제성공";
    	}
		
    	request.setAttribute("result", message);
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/common/result2.jsp");
	}
}
