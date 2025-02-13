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
		String sql = "SELECT * FROM PRODUCTS ORDER BY PRODUCTNUM ASC ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		List<ProductDTO> ar = new ArrayList();
		
		while(resultSet.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(resultSet.getInt(1));
			productDTO.setProductName(resultSet.getString(2));
			productDTO.setProductDetail(resultSet.getString(3));
			productDTO.setProductRate(resultSet.getDouble(4));
			productDTO.setProductDate(resultSet.getDate(5));
			
			ar.add(productDTO);
		}
		DBConnection.disConnect(resultSet, preparedStatement, connection);
		
		return ar;
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTNUM = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, productDTO.getProductNum());
		
		ResultSet resultSet = preparedStatement.executeQuery();

		if(resultSet.next()) {
			productDTO.setProductNum(resultSet.getInt(1));
			productDTO.setProductName(resultSet.getString(2));
			productDTO.setProductDetail(resultSet.getString(3));
			productDTO.setProductRate(resultSet.getDouble(4));
			productDTO.setProductDate(resultSet.getDate(5));
			
		} else {
			productDTO = null;
		}
		
		DBConnection.disConnect(resultSet, preparedStatement, connection);
		
		return productDTO;
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCTS "
				+ "VALUES (PRODUCTNUM_SEQ.NEXTVAL,?,?,?,SYSDATE)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, productDTO.getProductName());
		preparedStatement.setString(2, productDTO.getProductDetail());
		preparedStatement.setDouble(3, productDTO.getProductRate());
		
		int result = preparedStatement.executeUpdate();
		
		DBConnection.disConnect(preparedStatement, connection);
		
		return result;
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE PRODUCTS SET PRODUCTNAME =?, PRODUCTDETAIL=?,PRODUCTRATE=? WHERE PRODUCTNUM= ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, productDTO.getProductName());
		preparedStatement.setString(2, productDTO.getProductDetail());
		preparedStatement.setDouble(3, productDTO.getProductRate());
//		preparedStatement.setDate(4, productDTO.getProductDate());
		preparedStatement.setInt(4, productDTO.getProductNum());
		
		int result = preparedStatement.executeUpdate();
		
		DBConnection.disConnect(preparedStatement, connection);
		
		return result;
		
	}
}
