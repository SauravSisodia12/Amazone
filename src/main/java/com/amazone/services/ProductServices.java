package com.amazone.services;

import java.util.List;

import com.amazone.exception.IdNotFoundException;
import com.amazone.exception.UserNotFoundException;
import com.amazone.model.ProductDetails;

public interface ProductServices {

	public int login(String userName, String password) throws UserNotFoundException;
	public List<ProductDetails> viewAllProduct();
	void addProduct(ProductDetails productDetails);
	void updateProduct(int ProductId, double price) throws IdNotFoundException;
	void deleteProduct(int ProductId) throws IdNotFoundException;
}
