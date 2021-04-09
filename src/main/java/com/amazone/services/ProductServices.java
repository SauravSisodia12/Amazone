package com.amazone.services;

import com.amazone.exception.IdNotFoundException;
import com.amazone.model.ProductDetails;

public interface ProductServices {

	public void login(String userName, String password);
	void addProduct(ProductDetails productDetails);
	void updateProduct(int ProductId, double price) throws IdNotFoundException;
	void deleteProduct(int ProductId) throws IdNotFoundException;
}
