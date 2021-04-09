package com.amazone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amazone.model.ProductDetails;
import com.amazone.model.UserDetails;

public class UserDAOImple implements UserDAO {

	public int DAOlogin(String userName, String Password){
		
		String sql = "select name,password from userdetails where name = ? and password = ?";	
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		String username = null;
		String password = null;
		try {
			statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, userName);
			statement.setString(2, Password);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				username = rs.getString("userId");
				password = rs.getString("password");
				}
			if(username.equalsIgnoreCase(userName)&&(password.equalsIgnoreCase(Password)))
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

	public void DAOregister(UserDetails userdetails){
		
		String sql = "insert into userdetails values(?,?,?,?,?,?,?)";	
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, userdetails.getUserId());
			statement.setString(2, userdetails.getUserName());
			statement.setString(3, userdetails.getPassword());
			statement.setString(4, userdetails.getMailId());
			statement.setInt(5, userdetails.getMobile());
			statement.setString(6, userdetails.getAddress());
			statement.setDouble(7, userdetails.getWallet());
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

	public int DAOaddMoney(int amount) {
		return 0;
		
	}

	public List<ProductDetails> findAllProducts() {
		
		String sql = "select * from products";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<ProductDetails> allProductsList = new ArrayList<>();
		try {
		statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			int productId = rs.getInt("productId");
			String brand = rs.getString("brand");
			String category = rs.getString("category");
			double price = rs.getDouble("price");
			ProductDetails product = new ProductDetails(name, productId, brand, category, price);
			allProductsList .add(product);
			
		}
		} catch(SQLException e) {
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
		return allProductsList;
	}

	public List<ProductDetails> findProductByCategory(String category){
		
		String sql = "select * from products where category = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<ProductDetails> productsListByCategory = new ArrayList<>();
		try {
		statement = connection.prepareStatement(sql);
		statement.setString(1, category);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			int productId = rs.getInt("productId");
			String brand = rs.getString("brand");
			String ucategory = rs.getString("category");
			double price = rs.getDouble("price");
			ProductDetails product = new ProductDetails(name, productId, brand, ucategory, price);
			productsListByCategory .add(product);
			
			}
		} catch(SQLException e) {
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
		return productsListByCategory;
	}

	public List<ProductDetails> moveToCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDetails> findProductByBrand(String brand) {
		
		String sql = "select * from products where brand = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<ProductDetails> productsListByBrand = new ArrayList<>();
		try {
		statement = connection.prepareStatement(sql);
		statement.setString(1, brand);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			int productId = rs.getInt("productId");
			String ubrand = rs.getString("brand");
			String ucategory = rs.getString("category");
			double price = rs.getDouble("price");
			ProductDetails product = new ProductDetails(name, productId, ubrand, ucategory, price);
			productsListByBrand.add(product);
			}
		} catch(SQLException e) {
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
		return productsListByBrand;
	}



}
