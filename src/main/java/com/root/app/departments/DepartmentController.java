package com.root.app.departments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.root.app.ActionFoward;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DepartmentDAO departmentDAO;  
    private departmentService departmentService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentController() {
        super();
        // TODO Auto-generated constructor stub
        departmentDAO = new DepartmentDAO();
        departmentService = new departmentService();
    }

	/**
	 * 서버 요청시
	 * 	1. URL(ip:port/경로)
	 * 	2. 메서드 형식
	 * 		1) GET
	 * 			* 단순 요청시
	 * 			* 파라미터가 주소창에 노출(파라미터가 Header에 담김)
	 * 			* 작은 용량을 보낼 때 사용
	 * 		2) POST
	 * 			* 보안이 요구되는 요청시
	 * 			* 파라미터가 주소창에 노출되지 않음 (파라미터가 Body에 담김)
	 * 			* 큰 용량을 보낼 때 사용
	 * 
	 * 	3. 메서드 결정
	 * 		1) 주소창에 URL 직접 입력 - GET
	 * 		2) a 태그 사용 - GET
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String data = request.getRequestURI();
		
		String result = data.substring(data.lastIndexOf("/")+1);
		
		System.out.println(result);
		
		ActionFoward actionFoward = new ActionFoward();
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/errors/notfound.jsp");
		try {
		
			if(result.equals("departmentList.do")) {
				
				departmentService.getList(request, actionFoward);
			} else if(result.equals("departmentDetail.do")) {
				
				departmentService.getDetail(request, actionFoward);
			} else if(result.equals("departmentAdd.do")) {
				String method = request.getMethod();
				if(method.toUpperCase().equals("post")) {
					departmentService.add(request, actionFoward);
					
				} else {
					actionFoward.setFlag(true);
					actionFoward.setPath("/WEB-INF/views/departments/departmentAdd.jsp");
				}
			} else if(result.equals("departmentUpdateProcess.do")) {
				String method = request.getMethod();
				if(method.toUpperCase().equals("post")) {
					departmentService.updateProcess(request, actionFoward);
					
				} else {
					departmentService.update(request, actionFoward);
//					actionFoward.setFlag(true);
//					actionFoward.setPath("/WEB-INF/views/departments/departmentUpdateProcess.jsp");
				}
			} else if(result.equals("departmentDeleteProcess.do")) {
				departmentService.delete(request, actionFoward);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher(actionFoward.getPath());
		view.forward(request, response);
			
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
