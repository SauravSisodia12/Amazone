package com.amazone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amazone.model.ProductDetails;

public class ProductDAOImple implements ProductDAO {

	public int DAOlogin(String userId, String password) {
		
		String sql = "select userId , password from userdetails where userId = ? and password = ?";	
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		String adminUsername = null;
		String adminPassword = null;
		try {
			statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, userId);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				adminUsername = rs.getString("userId");
				adminPassword = rs.getString("password");
				}
			if(adminUsername.equalsIgnoreCase(userId)&&(adminPassword.equalsIgnoreCase(password)))
				result = 1;
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
		return result;
		
	}

	public void addoOneProduct(ProductDetails productDetails) {

		String sql = "insert into product values(?,?,?,?,?)";	
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, productDetails.getProductId());
			statement.setString(2, productDetails.getProductName());
			statement.setString(3, productDetails.getBrandName());
			statement.setString(4, productDetails.getProductCategory());
			statement.setDouble(5, productDetails.getPrice());
			statement.execute();
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
		
		String sql = "update product set price = ? where proid = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, price);
			statement.setInt(2, ProductId);
			result = statement.executeUpdate();
			if (result == 1)
				System.out.println("Updated \n");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
		return result;
		
	}

	public int deleteOneProduct(int ProductId) {
		
		String sql = "delete from product where proId = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, ProductId);
			result = statement.executeUpdate();
			if (result == 1)
				System.out.println("Deleted \n");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
		return result;
		
	}

	@Override
	public List<ProductDetails> findAllProduct() {
		
		String sql = "select * from product";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<ProductDetails> productList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int proId = rs.getInt("proId");
				String name = rs.getString("name");
				String brand = rs.getString("brand");
				String category = rs.getString("category");
				Double price = rs.getDouble("price");
				ProductDetails product = new ProductDetails(proId,name, brand, category, price);
				productList.add(product);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			DBConnection.closeConnection();
		}
		return productList;
	}
}
