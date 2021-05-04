package com.amazone.dao;

import java.util.List;

import com.amazone.model.ProductDetails;
import com.amazone.model.UserDetails;

public interface UserDAO {

	public int DAOlogin(String userName,String password);
	public void DAOregister(UserDetails userdetails);
	public int DAOaddMoney(int amount, String userid);
	public int checkBalance(String userid);
	public int updateWalletBalance(String userid, int amount);
	public int generateBill(int...ProdIds);
	
	List<ProductDetails> findAllProducts();
	List<ProductDetails> findProductByCategory(String category);
	List<ProductDetails> findProductByBrand(String brand); 
}
