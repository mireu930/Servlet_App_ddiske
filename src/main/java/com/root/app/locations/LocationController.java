package com.root.app.locations;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.root.app.ActionForward;

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
        locationService = new LocationService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocationDAO locationDAO = new LocationDAO();
		
		String uri = request.getRequestURI();
		
		ActionForward actionForward = new ActionForward();
		
		
		try {
			switch(this.useSubString(uri)) {
			case "list.do" :
				locationService.getList(request, actionForward);
				actionForward.setFlag(true);
				actionForward.setPath("/WEB-INF/views/locations/list.jsp");
				break;
			case "detail.do" :
				locationService.getDetail(request, actionForward);
				actionForward.setFlag(true);
				actionForward.setPath("/WEB-INF/views/locations/detail.jsp");
				break;
			case "add.do" :
				String method = request.getMethod();
				if(method.equalsIgnoreCase("post")) {
					locationService.add(request, actionForward);
				}else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/locations/add.jsp");
				}
				break;
			case "update.do" :
				String mthd = request.getMethod();
				if(mthd.equalsIgnoreCase("post")) {
					locationService.updateProcess(request, actionForward);
				}else {
					locationService.update(request, actionForward);
				}
				break;
			case "delete.do" :
				locationService.delete(request, actionForward);
				break;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
		view.forward(request, response);
	}
	
	private String useSubString(String data) {
		
		String result = data.substring(data.lastIndexOf("/")+1);
		
		return result;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
