package com.root.app.products;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.root.app.ActionFoward;

public class ProductService {
	private ProductDAO productDAO;
	
	 public ProductService() {
		productDAO = new ProductDAO();
	}

	public ActionFoward getList(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		List<ProductDTO> ar = productDAO.getList();
				
		request.setAttribute("list", ar);
		
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/products/list.jsp");
		
		return actionFoward;
	}
	
	public void getDetail(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		String id = request.getParameter("productNum");
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(Integer.parseInt(id));
		productDTO = productDAO.getDetail(productDTO);
		request.setAttribute("dto", productDTO);
		
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/products/detail.jsp");
	}
	
	public void add(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProductName(request.getParameter("productName"));
		productDTO.setProductDetail(request.getParameter("productDetail"));
		productDTO.setProductRate(Double.parseDouble(request.getParameter("productRate")));
		
		int result = productDAO.add(productDTO);
		
		actionFoward.setFlag(false);
		actionFoward.setPath("./list.do");
	}
	
	public void update(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		ProductDTO session = (ProductDTO)request.getSession().getAttribute("user");
		
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProductName(request.getParameter("productName"));
		productDTO.setProductDetail(request.getParameter("productDetail"));
		productDTO.setProductRate(Double.parseDouble(request.getParameter("productRate")));
//		productDTO.setProductDate(Date.parse(request.getParameter("productDate")));
		productDTO.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		
		
		int result = productDAO.update(productDTO);
		
		actionFoward.setFlag(false);
		actionFoward.setPath("./detail.do");
		
	}
}
