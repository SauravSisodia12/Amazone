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

	public int DAOlogin(String userId, String Password){
		
		String sql = "select userId , password from userdetails where userId = ? and password = ?";	
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		String username = null;
		String password = null;
		try {
			statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, userId);
			statement.setString(2, Password);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				username = rs.getString("userId");
				password = rs.getString("password");
				if(username.equalsIgnoreCase(userId)&&(password.equalsIgnoreCase(Password)))
					result = 1;
				}
		
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
			System.out.println("Successfully Registered");
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

	public int DAOaddMoney(int amount, String userid) {
		
		String sql = "update userdetails set wallet = ? where userId = ?";
		String sql2 = "select wallet from userdetails where userId = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		int walletAmount = 0;
		try {
			statement = connection.prepareStatement(sql2,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, userid);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				walletAmount = rs.getInt("wallet");
				}
			statement.close();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, walletAmount + amount);
			statement.setString(2, userid);
			result = statement.executeUpdate();
			if (result == 1)
				System.out.print(userid+"'s Updated Wallet Balance = "+(walletAmount+amount)+"\n");
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

	public List<ProductDetails> findAllProducts() {
		
		String sql = "select * from product";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<ProductDetails> allProductsList = new ArrayList<>();
		try {
		statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			int productId = rs.getInt("proId");
			String name = rs.getString("name");
			String brand = rs.getString("brand");
			String category = rs.getString("category");
			double price = rs.getDouble("price");
			ProductDetails product = new ProductDetails(productId, name, brand, category, price);
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
		
		String sql = "select * from product where category = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<ProductDetails> productsListByCategory = new ArrayList<>();
		try {
		statement = connection.prepareStatement(sql);
		statement.setString(1, category);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			int productId = rs.getInt("proId");
			String name = rs.getString("name");
			String brand = rs.getString("brand");
			String ucategory = rs.getString("category");
			double price = rs.getDouble("price");
			ProductDetails product = new ProductDetails(productId, name, brand, ucategory, price);
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

	@Override
	public List<ProductDetails> findProductByBrand(String brand) {
		
		String sql = "select * from product where brand = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		List<ProductDetails> productsListByBrand = new ArrayList<>();
		try {
		statement = connection.prepareStatement(sql);
		statement.setString(1, brand);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			int productId = rs.getInt("proId");
			String name = rs.getString("name");
			String ubrand = rs.getString("brand");
			String ucategory = rs.getString("category");
			double price = rs.getDouble("price");
			ProductDetails product = new ProductDetails(productId, name, ubrand, ucategory, price);
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

	@Override
	public int checkBalance(String userid) {
		
		String sql = "select wallet from userdetails where userId = ?";	
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int walletBalance = 0;
		try {
			statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, userid);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				walletBalance = rs.getInt("wallet");
				}
		
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
		return walletBalance;		
	}

	@Override
	public int generateBill(int...ProdIds) {
		int totalBill = 0;
		for (int i = 0; i < ProdIds.length; i++) {
			int price;
			String sql = "select name,price from product where proId = ?";	
			Connection connection = DBConnection.openConnection();
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				statement.setInt(1, ProdIds[i]);
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					price = rs.getInt("price");
					String name = rs.getString("name");
					totalBill = totalBill + price;
					System.out.println(name+" = "+price);
					}
			
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
		return totalBill;
		
	}

	@Override
	public int updateWalletBalance(String userid, int amount) {
		String sql = "update userdetails set wallet = ? where userId = ?";
		String sql2 = "select wallet from userdetails where userId = ?";
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = null;
		int result = 0;
		int walletAmount = 0;
		try {
			statement = connection.prepareStatement(sql2,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, userid);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				walletAmount = rs.getInt("wallet");
				}
			statement.close();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, walletAmount - amount);
			statement.setString(2, userid);
			result = statement.executeUpdate();
			if (result == 1)
				System.out.print(userid+"'s Updated Wallet Balance = "+(walletAmount-amount)+"\n");
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



}
