package com.amazone.dao;

import java.util.List;

import com.amazone.exception.UserNotFoundException;
import com.amazone.model.ProductDetails;

public interface ProductDAO {

	public int DAOlogin(String userName, String password);
	public List<ProductDetails> findAllProduct();
	void addoOneProduct(ProductDetails productDetails);
	int updateOneProduct(int ProductId, double price);
	int deleteOneProduct(int ProductId);
}
