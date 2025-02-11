package com.root.app.employee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.DateFormatter;

import com.root.app.ActionFoward;

public class EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeService() {
		employeeDAO = new EmployeeDAO();
	}

	public void add(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
//		employeeDTO.setFirtst_name(request.getParameter("first_name"));
//		employeeDTO.setLast_name(request.getParameter("last_name"));
//		employeeDTO.setEmail(request.getParameter("email"));
//		employeeDTO.setPhone_number(request.getParameter("phone_number"));
////		employeeDTO.setHire_date(Date.from(request.getParameter("hire_date"));
//		employeeDTO.setJob_id(request.getParameter("job_id"));
//		employeeDTO.setSalary(request.getParameter("salary"));
//		employeeDTO.setCommision(Double.parseDouble(request.getParameter("commision_pct")));
//		employeeDTO.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
//		employeeDTO.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
//		employeeDTO.setPassword(request.getParameter("password"));
		
		
		int result = employeeDAO.add(employeeDTO);
		
//		String message = "실패";
//		if(result > 0) {
//			message="등록성공";
//		}
		
		actionFoward.setFlag(false);
		actionFoward.setPath("../index.do");
	}
	
	public void getDetail(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
		employeeDTO.setPassword(request.getParameter("password"));
		
		employeeDTO = employeeDAO.getDetail(employeeDTO);
		
		if(employeeDTO != null) {
			actionFoward.setFlag(false);
			actionFoward.setPath("../index.do");
		}else {
			request.setAttribute("result", "로그인실패");
			request.setAttribute("path", "./login.do");
			actionFoward.setFlag(true);
			actionFoward.setPath("/WEB-INF/views/common/result.jsp");
		}
	}
	
	public void delete(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
		
		int result = employeeDAO.delete(employeeDTO);
		
		String message = "실패";
		
		if(result > 0) {
			message = "삭제되었습니다";
		}
		
		request.setAttribute("result", "로그인실패");
		request.setAttribute("path", "./login.do");
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/common/result.jsp");
	}
	
	public void update(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO.setFirtst_name(request.getParameter("first_name"));
		employeeDTO.setLast_name(request.getParameter("last_name"));
		employeeDTO.setEmail(request.getParameter("email"));
		employeeDTO.setPhone_number(request.getParameter("phone_number"));
		employeeDTO.setHire_date(LocalDate.parse(request.getParameter("hire_date")));
		employeeDTO.setJob_id(request.getParameter("job_id"));
		employeeDTO.setSalary(Integer.parseInt(request.getParameter("salary")));
		employeeDTO.setCommision(Double.parseDouble(request.getParameter("commision_pct")));
		employeeDTO.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
		employeeDTO.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
		employeeDTO.setPassword(request.getParameter("password"));
		
		int result = employeeDAO.update(employeeDTO);
		
		String message = "실패";
		
		if(result > 0) {
			message = "삭제되었습니다";
		}
		
		request.setAttribute("result", "로그인실패");
		request.setAttribute("path", "./login.do");
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/common/result.jsp");
	}

}
