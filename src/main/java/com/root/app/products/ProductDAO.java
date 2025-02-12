package com.root.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.root.app.utils.DBConnection;

public class ProductDAO {
	
	public List<ProductDTO> getList() throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		List<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductDate(rs.getDate("productdate"));
			productDTO.setProductDetail(rs.getString("productdetail"));
			productDTO.setProductName(rs.getString("productname"));
			productDTO.setProductNum(rs.getLong("productnum"));
			productDTO.setProductRate(rs.getDouble("productrate"));
			ar.add(productDTO);
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTNUM = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setLong(1, productDTO.getProductNum());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			productDTO = new ProductDTO();
			productDTO.setProductDate(rs.getDate("productdate"));
			productDTO.setProductDetail(rs.getString("productdetail"));
			productDTO.setProductName(rs.getString("productname"));
			productDTO.setProductNum(rs.getLong("productnum"));
			productDTO.setProductRate(rs.getDouble("productrate"));
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return productDTO;
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCTS (PRODUCTNUM, PRODUCTNAME, PRODUCTDATE)"
				+ " VALUES (PDT_NUM_SEQ.NEXTVAL, ?, SYSDATE)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, productDTO.getProductName());
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
		
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE PRODUCTS SET PRODUCTRATE = ?, PRODUCTDETAIL = ? WHERE PRODUCTNUM = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setDouble(1, productDTO.getProductRate());
		st.setString(2, productDTO.getProductDetail());
		st.setLong(3, productDTO.getProductNum());
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
		
	}

}
