package com.root.app.tests.products;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import com.root.app.products.ProductDAO;
import com.root.app.products.ProductDTO;

public class ProductTest {

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		ProductDTO productDTO = new ProductDTO();
		
		try {
			SimpleDateFormat fmt= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
			
			productDTO.setProductName("부자적금");
			productDTO.setProductRate(0.12);
			productDTO.setProductDetail("잉?");
			productDTO.setProductDate(Date.valueOf("2009-12-05"));
			productDTO.setProductNum(1);
			
			int result = productDAO.update(productDTO);
			
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
