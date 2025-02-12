package com.root.app.employee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;

import com.root.app.ActionFoward;

public class EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeService() {
		employeeDAO = new EmployeeDAO();
	}

	public void add(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO.setFirst_name(request.getParameter("first_name"));
		employeeDTO.setLast_name(request.getParameter("last_name"));
		employeeDTO.setEmail(request.getParameter("email"));
		employeeDTO.setPhone_number(request.getParameter("phone_number"));
//		employeeDTO.setHire_date(Date.from(request.getParameter("hire_date"));
		employeeDTO.setJob_id(request.getParameter("job_id"));
		employeeDTO.setSalary(Double.parseDouble(request.getParameter("salary")));
		employeeDTO.setCommision(Double.parseDouble(request.getParameter("commision_pct")));
		employeeDTO.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
		employeeDTO.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
		employeeDTO.setPassword(request.getParameter("password"));
		
		
		int result = employeeDAO.add(employeeDTO);
		
		if(result > 0) {
			actionFoward.setFlag(false);
			actionFoward.setPath("../index.do");
		} else {
			request.setAttribute("result", "로그인실패");
			request.setAttribute("path", "./join.do");
			actionFoward.setFlag(true);
			actionFoward.setPath("/WEB-INF/views/common/result.jsp");
		}
	}
	
	public void getList(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO = (EmployeeDTO)request.getSession().getAttribute("user");
		
//		LocalDate localDate = LocalDate.parse(request.getParameter("hire_date"));
//		Date date = Date.valueOf(localDate);
		
//		employeeDTO.setFirst_name(request.getParameter("first_name"));
//		employeeDTO.setLast_name(request.getParameter("last_name"));
//		employeeDTO.setEmail(request.getParameter("email"));
//		employeeDTO.setPhone_number(request.getParameter("phone_number"));
//		employeeDTO.setHire_date(date);
//		employeeDTO.setJob_id(request.getParameter("job_id"));
//		employeeDTO.setSalary(Double.parseDouble(request.getParameter("salary")));
//		employeeDTO.setCommision(Double.parseDouble(request.getParameter("commision_pct")));
//		employeeDTO.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
//		employeeDTO.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
//		employeeDTO.setPassword(request.getParameter("password"));
		
		EmployeeDTO result = employeeDAO.getList(employeeDTO);
		request.setAttribute("user", result);
	}
	
	public void getDetail(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
		employeeDTO.setPassword(request.getParameter("password"));
		
		employeeDTO = employeeDAO.getDetail(employeeDTO);
		
		if(employeeDTO != null) {
			
			HttpSession session = request.getSession();
//			ServletContext context = request.getServletContext();
			
			session.setAttribute("user", employeeDTO);
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
		EmployeeDTO employeeDTO2 = (EmployeeDTO)request.getSession().getAttribute("user");
		
//		LocalDate localDate = LocalDate.parse(request.getParameter("hire_date"));
//		Date date = Date.valueOf(localDate);
//		employeeDTO.setEmail(request.getParameter("email"));
//		employeeDTO.setPhone_number(request.getParameter("phone_number"));
//		employeeDTO.setHire_date(date);
//		employeeDTO.setJob_id(request.getParameter("job_id"));
//		employeeDTO.setSalary(Double.parseDouble(request.getParameter("salary")));
//		employeeDTO.setCommision(Double.parseDouble(request.getParameter("commision_pct")));
//		employeeDTO.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
//		employeeDTO.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
//		employeeDTO.setPassword(request.getParameter("password"));
		employeeDTO.setFirst_name(request.getParameter("first_name"));
		employeeDTO.setLast_name(request.getParameter("last_name"));
		employeeDTO.setEmployee_id(employeeDTO2.getEmployee_id());
		
		
		int result = employeeDAO.update(employeeDTO);
//		request.setAttribute("result", employeeDTO);
		if(result>0) {
			employeeDTO2.setFirst_name(employeeDTO.getFirst_name());
		}
		actionFoward.setFlag(false);
		actionFoward.setPath("./mypage.do");		
	}
	
	public void updateProcess(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		String first = (String)request.getSession().getAttribute("first_name");
		String second = (String)request.getSession().getAttribute("last_name");
		
		
		
		employeeDTO.setFirst_name(first);
		employeeDTO.setLast_name(second);
		
		int result = employeeDAO.update(employeeDTO);
		
		request.setAttribute("result", result);
		
		String message = "실패";
		if(result > 0) {
			message = "성공";
		}
	}

}
