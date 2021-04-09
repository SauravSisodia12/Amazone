package com.amazone.dao;

import java.util.List;

import com.amazone.model.ProductDetails;
import com.amazone.model.UserDetails;

public interface UserDAO {

	public int DAOlogin(String userName,String password);
	public void DAOregister(UserDetails userdetails);
	public int DAOaddMoney(int amount);
	
	List<ProductDetails> findAllProducts();
	List<ProductDetails> findProductByCategory(String category);
	List<ProductDetails> findProductByBrand(String brand); 
	List<ProductDetails> moveToCart();
}
