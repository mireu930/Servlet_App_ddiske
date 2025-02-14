package com.root.app.products;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.root.app.ActionFoward;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
        productService = new ProductService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("productController");
		
		String uri = request.getRequestURI();
		
		uri = uri.substring(uri.lastIndexOf("/")+1);
		
		ActionFoward actionFoward = new ActionFoward();
		
		try {
			if(uri.equals("list.do")) {
				productService.getList(request, actionFoward);
				
			} else if(uri.equals("detail.do")) {
				productService.getDetail(request, actionFoward);
				
			} else if(uri.equals("add.do")) {
				String method = request.getMethod();
				
				if(method.toUpperCase().equals("POST")) {
					productService.add(request, actionFoward);
				} else {
					actionFoward.setFlag(true);
					actionFoward.setPath("/WEB-INF/views/products/add.jsp");
				}
				
			} else if(uri.equals("update.do")) {
				String method = request.getMethod();
				
				if(method.toUpperCase().equals("POST")) {
					productService.updateProcess(request, actionFoward);
				} else {
					productService.update(request, actionFoward);
					
				}
			}
			
		} catch(Exception e) {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
