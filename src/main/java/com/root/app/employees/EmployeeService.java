package com.root.app.employees;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.root.app.ActionForward;

public class EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeService() {
		employeeDAO = new EmployeeDAO();
	}
	
	public void add(HttpServletRequest request, ActionForward actionForward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setCommission_pct(Double.parseDouble(request.getParameter("commission_pct")));
		employeeDTO.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
		employeeDTO.setEmail(request.getParameter("email"));
		employeeDTO.setEmployee_id(Integer.parseInt(request.getParameter("manager_id")));
		employeeDTO.setFirst_name(request.getParameter("first_name"));
		employeeDTO.setJob_id(request.getParameter("job_id"));
		employeeDTO.setLast_name(request.getParameter("last_name"));
		employeeDTO.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
		employeeDTO.setPassword(request.getParameter("password"));
		employeeDTO.setPhone_number(request.getParameter("phone_number"));
		employeeDTO.setSalary(Double.parseDouble(request.getParameter("salary")));
		
		int result = employeeDAO.add(employeeDTO);
		String str = "등록 실패";
		
		if(result > 0) {
			str = "등록 완료";
		}
		
		request.setAttribute("result", str);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		
	}
	
	public void login(HttpServletRequest request, ActionForward actionForward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
		employeeDTO.setPassword(request.getParameter("password"));
		employeeDTO = employeeDAO.login(employeeDTO);
		
		if(employeeDTO != null) {
			// /index.do
			HttpSession session = request.getSession();
			session.setAttribute("user", employeeDTO);
			actionForward.setFlag(false);
			actionForward.setPath("../index.do");
		}else {
			request.setAttribute("result", "로그인 실패");
			request.setAttribute("path", "./login.do");
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		}
		
	}
	
	public void getDetail(HttpServletRequest request, ActionForward actionForward) throws Exception {
//		HttpSession session = request.getSession();
//		EmployeeDTO employeeDTO = (EmployeeDTO)session.getAttribute("user");
//		employeeDTO = employeeDAO.getDetail(employeeDTO);
//		request.setAttribute("user", employeeDTO);
		EmployeeDTO employeeDTO = (EmployeeDTO)request.getSession().getAttribute("user");
		EmployeeDTO result = employeeDAO.getDetail(employeeDTO);
		request.setAttribute("user", result);
	}
	
	public void update(HttpServletRequest request, ActionForward actionForward) throws Exception {
		HttpSession session = request.getSession();
		EmployeeDTO employeeDTO = (EmployeeDTO)session.getAttribute("user");
		employeeDTO.setFirst_name(request.getParameter("first_name"));
		employeeDTO.setLast_name(request.getParameter("last_name"));
		int result = employeeDAO.update(employeeDTO);
		
		if(result > 0) {
			employeeDTO = employeeDAO.getDetail(employeeDTO);
			session.setAttribute("user", employeeDTO);
			actionForward.setFlag(false);
			actionForward.setPath("./mypage.do");			
		}
	}

}
