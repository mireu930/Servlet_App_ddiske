package com.root.app.products;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

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
		
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		productDTO = productDAO.getDetail(productDTO);
		
		request.setAttribute("dto", productDTO);
		
		actionFoward.setFlag(true);
		actionFoward.setPath("/WEB-INF/views/products/update.jsp");
		
	}
	
	public void updateProcess(HttpServletRequest request, ActionFoward actionFoward) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		
//		String productRateStr = request.getParameter("productRate");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-/MM-dd");
//		java.util.Date parsedDate = sdf.parse(productRateStr);
		
		productDTO.setProductName(request.getParameter("productName"));
		productDTO.setProductDetail(request.getParameter("productDetail"));
		productDTO.setProductRate(Double.parseDouble(request.getParameter("productRate")));
//		productDTO.setProductDate(parsedDate.getTime());
		
		
		int result = productDAO.update(productDTO);
		String str = "실패";
		if(result>0) {
			actionFoward.setFlag(false);
			actionFoward.setPath("./detail.do");
		}else {
			request.setAttribute("result", str);
			request.setAttribute("path", "./list.do");
			actionFoward.setFlag(true);
			actionFoward.setPath("/WEB-INF/views/commons/result.jsp");
		}
		
		}

}
