package com.amazone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.amazone.model.ProductDetails;

public class ProductDAOImple implements ProductDAO {

	public void DAOlogin(String userName, String password) {
	
		
	}

	public void addoOneProduct(ProductDetails productDetails) {

		String sql = "insert into products values(?,?,?,?,?)";	
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, productDetails.getProductName());
			statement.setInt(2, productDetails.getProductId());
			statement.setString(3, productDetails.getBrandName());
			statement.setString(4, productDetails.getProductCategory());
			statement.setDouble(5, productDetails.getPrice());
			statement.execute();
			System.out.println("Row Inserted");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if(statement!=null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
			}	
	}

	public int updateOneProduct(int ProductId, double price){
		return 0;
		
	}

	public int deleteOneProduct(int ProductId) {
		return 0;
		
	}
}
