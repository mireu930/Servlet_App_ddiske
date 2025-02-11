package com.root.app.locations;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.root.app.ActionFoward;
import com.root.app.departments.DepartmentDAO;

/**
 * Servlet implementation class LocationController
 */
@WebServlet("/LocationController")
public class LocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocationService locationService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationController() {
        super();
        // TODO Auto-generated constructor stub
        locationService = new LocationService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uri = request.getRequestURI();
		
		uri = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(uri);
		
		ActionFoward actionFoward = new ActionFoward();
		
		try {
			if(uri.equals("locationList.do")) {
				locationService.getList(request, actionFoward);
			} else if(uri.equals("locationDetail.do")) {
				locationService.getDetail(request, actionFoward);					
				
			} else if(uri.equals("locationAdd.do")) {
				String method = request.getMethod();
				if(method.toUpperCase().equals("POST")) {
					locationService.add(request, actionFoward);					
				}else {
					actionFoward.setFlag(true);
					actionFoward.setPath("/WEB-INF/views/locations/locationAdd.jsp");
				}
			} else if(uri.equals("locationUpdate.do")) {
				String method = request.getMethod();
				if(method.toUpperCase().equals("POST")) {
					locationService.updateProcess(request, actionFoward);					
				}else {
					locationService.update(request, actionFoward);
				}
			} else if(uri.equals("locationDeleteProcess.do")) {
				locationService.delete(request, actionFoward);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher(actionFoward.getPath());
		view.forward(request, response);
	}
	
//	private String useSubString(String data) {
//		
//		String result = data.substring(data.lastIndexOf("/")+1);
//		
//		return result;
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
