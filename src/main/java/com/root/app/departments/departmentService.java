package com.root.app.departments;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.root.app.ActionFoward;

public class departmentService {
	
	private DepartmentDAO departmentDAO;
	
	public departmentService() {
		this.departmentDAO = new DepartmentDAO();
	}
	
	public ActionFoward getList(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		List<DepartmentDTO> ar = departmentDAO.getList();
		request.setAttribute("list", ar);
		
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/departments/departmentList.jsp");
		
		return actionFoward;
	}
	
	public ActionFoward getDetail(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		String id = request.getParameter("department_id");
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(Long.parseLong(id));
		departmentDTO = departmentDAO.getDetail(departmentDTO);
		request.setAttribute("dto", departmentDTO);
		
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/departments/departmentDetail.jsp");
		
		return actionFoward;
	}
	
	public void add(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_name(request.getParameter("department_name"));
		departmentDTO.setManager_id(Long.parseLong(request.getParameter("manager_id")));
		
		int result = departmentDAO.add(departmentDTO);
		String message = "실패";
		
		if(result>0) {
			message = "등록성공";
		}
		request.setAttribute("result", message);
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/commons/result.jsp");
	}
	//DB에서 수정할 데이터조회
	public void update(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(Long.parseLong(request.getParameter("department_id")));
		departmentDTO = departmentDAO.getDetail(departmentDTO);
		
		request.setAttribute("dto", departmentDTO);
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/departments/departmentUpdateProcess.jsp");
	}
	
	//데이터수정
	public void updateProcess(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		String id = request.getParameter("department_id");
	    String name = request.getParameter("department_name");
	    String m = request.getParameter("manager_id");
	    String i = request.getParameter("location_id");
	    
	    DepartmentDTO departmentDTO = new DepartmentDTO();
	    departmentDTO.setDepartment_id(Long.parseLong(id));
	    departmentDTO.setDepartment_name(name);
	    departmentDTO.setDepartment_id(Long.parseLong(m));
	    departmentDTO.setDepartment_id(Long.parseLong(i));
	    
	    int result = departmentDAO.update(departmentDTO);
	    
	    String message = "실패";
		
		if(result>0) {
			message = "등록수정성공";
		}
		request.setAttribute("result", message);
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/commons/result.jsp");
	}
	
	public void delete(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(Long.parseLong(request.getParameter("department_id")));
		int result = departmentDAO.delete(departmentDTO);
		
		String message = "실패";
		
		if(result>0) {
			message = "삭제성공";
		}
		
		request.setAttribute("result", message);
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/commons/result.jsp");
	}
}
