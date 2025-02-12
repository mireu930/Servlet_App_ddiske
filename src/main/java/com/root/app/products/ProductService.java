package com.root.app.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.root.app.ActionForward;

public class ProductService {
	
	private ProductDAO productDAO;
	
	public ProductService() {
		productDAO = new ProductDAO();
	}
	
	public void getList(HttpServletRequest request, ActionForward actionForward)throws Exception {
		
		List<ProductDTO> ar = productDAO.getList();
		request.setAttribute("list", ar);
		
	}
	
	public void getDetail(HttpServletRequest request, ActionForward actionForward)throws Exception {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(Long.parseLong(request.getParameter("productnum")));
		productDTO = productDAO.getDetail(productDTO);
		request.setAttribute("product", productDTO);
		
		
	}
	
	public void add(HttpServletRequest request, ActionForward actionForward)throws Exception {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName(request.getParameter("productname"));
		productDAO.add(productDTO);
		
	}
	
	public void update(HttpServletRequest request, ActionForward actionForward)throws Exception {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductRate(Double.parseDouble(request.getParameter("productrate")));
		productDTO.setProductDetail(request.getParameter("productdetail"));
		productDAO.update(productDTO);
		
	}

}
