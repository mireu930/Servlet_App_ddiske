package com.root.app.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.root.app.ActionFoward;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		super();
		// TODO Auto-generated constructor stub
		employeeService = new EmployeeService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("EmployeeController");

		String data = request.getRequestURI();

		ActionFoward actionFoward = new ActionFoward();
		String result = data.substring(data.lastIndexOf("/") + 1);

		try {
			if (result.equals("join.do")) {
				String method = request.getMethod();
				if (method.toUpperCase().equals("POST")) {
					employeeService.add(request, actionFoward);
				} else {
					actionFoward.setFlag(true);
					actionFoward.setPath("/WEB-INF/views/employee/join.jsp");
				}

			} else if (result.equals("login.do")) {
				String method = request.getMethod();
				if (method.toUpperCase().equals("POST")) {
					employeeService.getDetail(request, actionFoward);
				} else {
					actionFoward.setFlag(true);
					actionFoward.setPath("/WEB-INF/views/employee/login.jsp");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(actionFoward.isFlag()) {
			RequestDispatcher view = request.getRequestDispatcher(actionFoward.getPath());
			view.forward(request, response);
		} else {
			response.sendRedirect(actionFoward.getPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
