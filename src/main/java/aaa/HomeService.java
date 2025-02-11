package aaa;

import java.util.Calendar;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class HomeService {

	public void date(HttpServletRequest request) {
		Calendar calendar = Calendar.getInstance();
		
		request.setAttribute("now", calendar);
	}
}
