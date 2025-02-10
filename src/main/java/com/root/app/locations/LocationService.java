package com.root.app.locations;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.root.app.ActionForward;

public class LocationService {
	
	private LocationDAO locationDAO;
	
	public LocationService() {
		locationDAO = new LocationDAO();
	}
	
	public void getList(HttpServletRequest request, ActionForward actionForward) throws Exception {
		List<LocationDTO> ar = locationDAO.getList();
		request.setAttribute("list", ar);
		
	}
	
	public void getDetail(HttpServletRequest request, ActionForward actionForward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
		locationDTO = locationDAO.getDetail(locationDTO);
		request.setAttribute("dto", locationDTO);
		
	}
	
	public void add(HttpServletRequest request, ActionForward actionForward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setCity(request.getParameter("city"));
		locationDTO.setCountry_id(request.getParameter("country_id"));
		locationDTO.setPostal_code(request.getParameter("postal_code"));
		locationDTO.setState_province(request.getParameter("state_province"));
		locationDTO.setStreet_address(request.getParameter("street_address"));
		int result = locationDAO.add(locationDTO);
		
		String str = "실패";
		if(result > 0) {
			str = "추가 완료";
		}
		
		request.setAttribute("result", str);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		
	}
	
	public void update(HttpServletRequest request, ActionForward actionForward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
		locationDTO = locationDAO.getDetail(locationDTO);
		locationDAO.update(locationDTO);
		request.setAttribute("dto", locationDTO);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/locations/update.jsp");
	}
	
	public void updateProcess(HttpServletRequest request, ActionForward actionForward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setCity(request.getParameter("city"));
		locationDTO.setCountry_id(request.getParameter("country_id"));
		locationDTO.setPostal_code(request.getParameter("postal_code"));
		locationDTO.setState_province(request.getParameter("state_province"));
		locationDTO.setStreet_address(request.getParameter("street_address"));
		locationDTO.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
		int result = locationDAO.update(locationDTO);
		String str = "실패";
		
		if(result > 0) {
			str = "수정 완료";
		}
		
		request.setAttribute("result", str);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
	}
	
	public void delete(HttpServletRequest request, ActionForward actionForward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
		int result = locationDAO.delete(locationDTO);
		String str = "실패";
		
		if(result > 0) {
			str = "삭제 완료";
		}
		
		request.setAttribute("result", str);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
	}

}
