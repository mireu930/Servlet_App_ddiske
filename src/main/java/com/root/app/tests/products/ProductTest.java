package com.root.app.tests.products;

import java.util.List;

import com.root.app.products.ProductDAO;
import com.root.app.products.ProductDTO;

public class ProductTest {

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		ProductDTO productDTO = new ProductDTO();
		
		try {
			productDTO.setProductName("abc");
			productDTO.setProductDetail("abcdefg");
			productDTO.setProductRate(0.12);
			
			int result = productDAO.add(productDTO);
			
			if(result > 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
