package com.amazone.services;

import java.util.List;

import com.amazone.exception.BrandNotFoundException;
import com.amazone.exception.CategoryNotFoundException;
import com.amazone.exception.UserAlreadyExistException;
import com.amazone.exception.UserNotFoundException;
import com.amazone.model.ProductDetails;
import com.amazone.model.UserDetails;


public interface UserServices {

	public int login(String userName,String password) throws UserNotFoundException;
	public void register(UserDetails userdetails) throws UserAlreadyExistException;
	public int addMoney(int amount,String userid);
	public int checkBalance(String userid);
	public int updateWalletBalance(String userid,int amount);
	public int generateBill(int...ProdIds);
	
	List<ProductDetails> viewAllProducts();
	List<ProductDetails> viewProductByCategory(String category) throws CategoryNotFoundException;
	List<ProductDetails> ViewProductByPrice(int choice);
	List<ProductDetails> ViewProductByBrand(String brand) throws BrandNotFoundException;
}
