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
		
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/products/list.jsp");
	}
	
	public void getDetail(HttpServletRequest request, ActionForward actionForward)throws Exception {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(Long.parseLong(request.getParameter("productnum")));
		productDTO = productDAO.getDetail(productDTO);
		request.setAttribute("product", productDTO);
		
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/products/detail.jsp");
	}
	
	public void add(HttpServletRequest request, ActionForward actionForward)throws Exception {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName(request.getParameter("productname"));
		int result = productDAO.add(productDTO);
		
		
		if(result > 0) {
			actionForward.setFlag(false);
			actionForward.setPath("./list.do");
		}else {
			request.setAttribute("result", "등록 실패");
			request.setAttribute("path", "./add.do");
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		}
		
	}
	
	public void updateProcess(HttpServletRequest request, ActionForward actionForward)throws Exception {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(Long.parseLong(request.getParameter("productnum")));
		productDTO.setProductRate(Double.parseDouble(request.getParameter("productrate")));
		productDTO.setProductDetail(request.getParameter("productdetail"));
		int result = productDAO.update(productDTO);
		
		if(result > 0) {
			request.setAttribute("product", productDAO.getDetail(productDTO));
			actionForward.setFlag(false);
			actionForward.setPath("./detail.do?productnum="+request.getParameter("productnum"));
		}else {
			request.setAttribute("result", "수정 실패");
			request.setAttribute("path", "./update.do");
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		}
		
	}
	
	public void update(HttpServletRequest request, ActionForward actionForward)throws Exception {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(Long.parseLong(request.getParameter("productnum")));
		productDTO = productDAO.getDetail(productDTO);
		
		request.setAttribute("product", productDTO);
		
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/products/update.jsp");
	}

}
